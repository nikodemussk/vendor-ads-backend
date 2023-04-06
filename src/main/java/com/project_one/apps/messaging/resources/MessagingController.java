package com.project_one.apps.messaging.resources;

import com.project_one.apps.messaging.repository.MessagingRepository;
import com.project_one.apps.messaging.repository.model.Messaging;
import com.project_one.apps.messaging.repository.model.VendorListMessage;
import com.project_one.apps.messaging.repository.model.VendorMessageData;
import com.project_one.apps.messaging.resources.model.MessagingRequestSpec;
import com.project_one.apps.user.adapter.UserRepository;
import com.project_one.apps.user.adapter.model.User;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class MessagingController {

  @Autowired
  private MessagingRepository messagingRepository;

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/createMessage")
  public ResponseEntity<String> createMessage(@RequestBody MessagingRequestSpec messagingRequestSpec) {
    log.info("Request API: /createMessage\nRequest Body: {}", messagingRequestSpec);
    Messaging messaging = Messaging.builder()
        .userId(messagingRequestSpec.userId())
        .sender(messagingRequestSpec.sender())
        .chatId(messagingRequestSpec.chatId())
        .vendorId(messagingRequestSpec.vendorId())
        .advertisementId(messagingRequestSpec.advertisementId())
        .createdDateTime(ZonedDateTime.now())
        .message(messagingRequestSpec.message()).build();
    messagingRepository.save(messaging);
    return ResponseEntity.accepted().build();
  }

  @PostMapping("/getAllMessage")
  public ResponseEntity<List<VendorListMessage>> getMessage(@RequestBody MessagingRequestSpec messagingRequestSpec) {
    log.info("Request API: /getAllMessage\nRequest Param: {}", messagingRequestSpec);
    return ResponseEntity.ok(messagingRepository.findChatByVendorId(messagingRequestSpec.vendorId()));
  }

  @PostMapping("/getMessage")
  public ResponseEntity<List<Messaging>> getMessageByUserIdAndVendorId(@RequestBody MessagingRequestSpec messagingRequestSpec) {
    log.info("Request API: /getMessage\nRequest Param: {}",messagingRequestSpec);
    return ResponseEntity.ok(messagingRepository.findAllByVendorIdAndUserIdOrderByCreatedDateTime(messagingRequestSpec.vendorId(), messagingRequestSpec.userId()));
  }

  @PostMapping("/getMessageByVendor")
  public ResponseEntity<Set<User>> getMessageByVendor(@RequestBody MessagingRequestSpec messagingRequestSpec) {
    log.info("Request API: /getMessage\nRequest Param: {}",messagingRequestSpec);
    List<VendorMessageData> messaging = messagingRepository.findUserIdAndChatIdByVendorId(messagingRequestSpec.vendorId());
    log.info("{}", messaging);
    Set<User> users = new HashSet<>();
    messaging.forEach(message -> users.add(userRepository.findByUserId(java.util.UUID.fromString(message.getUserId()))));
    return ResponseEntity.ok(users);
  }
}
