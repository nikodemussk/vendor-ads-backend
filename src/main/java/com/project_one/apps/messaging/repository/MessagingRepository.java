package com.project_one.apps.messaging.repository;

import com.project_one.apps.messaging.repository.model.Messaging;
import com.project_one.apps.messaging.repository.model.VendorListMessage;
import com.project_one.apps.messaging.repository.model.VendorMessageData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagingRepository extends JpaRepository<Messaging, Integer> {

  @Query(
      value = "select distinct m.userId as userId, u.fullName as userFullName from Messaging m join Users u on m.userId = u.userId",
      nativeQuery = true)
  List<VendorListMessage> findChatByVendorId(String vendorId);
  List<Messaging> findAllByVendorIdAndUserIdOrderByCreatedDateTime(String vendorId, String userId);

  @Query(
//      value = "select distinct m.userId as userId, m.chatId as chatId from Messaging m where m.vendorId = ?1",
      nativeQuery = true
  )
  List<VendorMessageData> findUserIdAndChatIdByVendorId(String vendorId);
}
