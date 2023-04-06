package com.project_one.apps.messaging.repository.model;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@NamedNativeQuery(name = "Messaging.findUserIdAndChatIdByVendorId",
    query = "select distinct m.userId as userId, m.chatId as chatId from Messaging m where m.vendorId = :vendorId",
    resultSetMapping = "Mapping.VendorMessageData")
@SqlResultSetMapping(name = "Mapping.VendorMessageData",
    classes = @ConstructorResult(targetClass = VendorMessageData.class,
        columns = {@ColumnResult(name = "userId"),
            @ColumnResult(name = "chatId")}))
public class VendorMessageData {

  private String userId;
  private String chatId;

}
