package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private Long chatRoomId;
    private Long studentOneId;
    private Long studentTwoId;
    private LocalDateTime createdAt;
    private LocalDateTime lastMessageAt;
    private String lastMessagePreview;
    private boolean isActive;
    private int studentOneUnreadCount;
    private int studentTwoUnreadCount;
    private List<Message> messages;

    protected ChatRoom() {}

    private ChatRoom(Builder builder) {
        this.chatRoomId = builder.chatRoomId;
        this.studentOneId = builder.studentOneId;
        this.studentTwoId = builder.studentTwoId;
        this.createdAt = builder.createdAt;
        this.lastMessageAt = builder.lastMessageAt;
        this.lastMessagePreview = builder.lastMessagePreview;
        this.isActive = builder.isActive;
        this.studentOneUnreadCount = builder.studentOneUnreadCount;
        this.studentTwoUnreadCount = builder.studentTwoUnreadCount;
        this.messages = builder.messages != null ? builder.messages : new ArrayList<>();
    }

    // Getters
    public Long getChatRoomId() { return chatRoomId; }
    public Long getStudentOneId() { return studentOneId; }
    public Long getStudentTwoId() { return studentTwoId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getLastMessageAt() { return lastMessageAt; }
    public String getLastMessagePreview() { return lastMessagePreview; }
    public boolean isActive() { return isActive; }
    public int getStudentOneUnreadCount() { return studentOneUnreadCount; }
    public int getStudentTwoUnreadCount() { return studentTwoUnreadCount; }
    public List<Message> getMessages() { return messages; }

    public int getUnreadCount(Long studentId) {
        if (studentId.equals(studentOneId)) {
            return studentOneUnreadCount;
        } else if (studentId.equals(studentTwoId)) {
            return studentTwoUnreadCount;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "chatRoomId=" + chatRoomId +
                ", lastMessagePreview='" + lastMessagePreview + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public static class Builder {
        private Long chatRoomId;
        private Long studentOneId;
        private Long studentTwoId;
        private LocalDateTime createdAt = LocalDateTime.now();
        private LocalDateTime lastMessageAt;
        private String lastMessagePreview;
        private boolean isActive = true;
        private int studentOneUnreadCount = 0;
        private int studentTwoUnreadCount = 0;
        private List<Message> messages;

        public Builder setChatRoomId(Long chatRoomId) { this.chatRoomId = chatRoomId; return this; }
        public Builder setStudentOneId(Long studentOneId) { this.studentOneId = studentOneId; return this; }
        public Builder setStudentTwoId(Long studentTwoId) { this.studentTwoId = studentTwoId; return this; }
        public Builder setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        public Builder setLastMessageAt(LocalDateTime lastMessageAt) { this.lastMessageAt = lastMessageAt; return this; }
        public Builder setLastMessagePreview(String lastMessagePreview) { this.lastMessagePreview = lastMessagePreview; return this; }
        public Builder setIsActive(boolean isActive) { this.isActive = isActive; return this; }
        public Builder setStudentOneUnreadCount(int studentOneUnreadCount) { this.studentOneUnreadCount = studentOneUnreadCount; return this; }
        public Builder setStudentTwoUnreadCount(int studentTwoUnreadCount) { this.studentTwoUnreadCount = studentTwoUnreadCount; return this; }
        public Builder setMessages(List<Message> messages) { this.messages = messages; return this; }

        public ChatRoom build() { return new ChatRoom(this); }
    }
}
