package com.example.bai2
// Định nghĩa lớp Attachment
data class ApiResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<ListItem>
)

data class Attachment(
    val fileName: String,
    val fileUrl: String,
    val id: Int
)

// Định nghĩa lớp Reminder
data class Reminder(
    val id: Int,
    val time: String,
    val type: String
)

// Định nghĩa lớp Subtask
data class Subtask(
    val id: Int,
    val isCompleted: Boolean,
    val title: String
)

// Định nghĩa lớp ListItem
data class ListItem(
    val attachments: List<Attachment>,
    val category: String,
    val createdAt: String,
    val description: String,
    val dueDate: String,
    val id: Int,
    val priority: String,
    val reminders: List<Reminder>,
    val status: String,
    val subtasks: List<Subtask>,
    val title: String,
    val updatedAt: String
)
