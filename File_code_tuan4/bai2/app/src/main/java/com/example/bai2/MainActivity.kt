package com.example.bai2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bai2.ui.theme.Bai2Theme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private val apiRepository = ApiRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai2Theme {
                AppNavHost(apiRepository)
            }
        }
    }
}
val mautrongbutton = Color(0xFF2196F3)
val mauButton = Color(0xFF2196F3) // Alpha: 1A, Màu: 2196F3 (Xanh)
val mauChu = Color(0xFF2196F3)
@Composable
fun AppNavHost(apiRepository: ApiRepository) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController, apiRepository)
        }
        composable("detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")
            Log.d("AppNavHost", "Received taskId: $taskId")
            DetailScreen(taskId = taskId, apiRepository = apiRepository)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, apiRepository: ApiRepository) {
    var tasks by remember { mutableStateOf<List<ListItem>?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        apiRepository.fetchTasks { result ->
            tasks = result
            isLoading = false
        }
    }

    Scaffold(topBar = { TopAppBar(title = { Row {
        Image(painter = painterResource(R.drawable.image_2), contentDescription = "Anh2"
            , modifier = Modifier
                .padding(start = 25.dp,top = 20.dp)
                .size(width =  40.dp, height = 40.dp)

        )

        Text(text = "LazyColumn", fontSize =24.sp, color = mauChu, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 65.dp, top = 20.dp)


        )

    } }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            if (isLoading) {
                Text(text = "⏳ Đang tải dữ liệu...")
            } else {
                tasks?.let { list ->
                    if (list.isNotEmpty()) {
                        LazyColumn {
                            items(list) { task ->
                                TaskItem(task) {
                                    task.id?.let { id ->
                                        Log.d("MainScreen", "Navigating to detail/$id")
                                        navController.navigate("detail/$id")
                                    } ?: Log.e("MainScreen", "Task ID is null, cannot navigate!")
                                }
                            }
                        }
                    } else {
                        Text(text = "🚫 Không có dữ liệu.")
                    }
                } ?: Text(text = "⚠️ Lỗi tải dữ liệu.")
            }
        }
    }
}

@Composable
fun TaskItem(task: ListItem, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "📌 ${task.title ?: "(Không có tiêu đề)"}", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "📅 Ngày hết hạn: ${task.dueDate ?: "(Không có dữ liệu)"}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "⚡ Mức độ ưu tiên: ${task.priority ?: "(Không có dữ liệu)"}", style = MaterialTheme.typography.bodyMedium)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    Text(text = task.description ?: "(Không có mô tả)", style = MaterialTheme.typography.bodySmall)
                }
                Image(
                    painter = painterResource(id = R.drawable.blackbutton),
                    contentDescription = "ButtonBlack",
                    modifier = Modifier.padding(start = 8.dp)
                        .size(42.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(taskId: String?, apiRepository: ApiRepository) {
    val task = remember { mutableStateOf<ListItem?>(null) }
    val isLoading = remember { mutableStateOf(true) }

    val taskIdInt = taskId?.toIntOrNull()
    Log.d("DetailScreen", "Received taskId: $taskIdInt")

    if (taskIdInt == null || taskIdInt == -1) {
        Text(text = "⚠️ ID không hợp lệ.")
        return
    }

    LaunchedEffect(taskIdInt) {
        apiRepository.getTodoById(taskIdInt) { result ->
            task.value = result
            isLoading.value = false
        }
    }

    Scaffold(topBar = { TopAppBar(title = { Row {
        Image(painter = painterResource(R.drawable.image_2), contentDescription = "Anh2"
            , modifier = Modifier
                .padding(start = 25.dp,top = 20.dp)
                .size(width =  40.dp, height = 40.dp)

        )

        Text(text = "LazyColumn", fontSize =24.sp, color = mauChu, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 65.dp, top = 20.dp)


        )

    } }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            if (isLoading.value) {
                Text(text = "⏳ Đang tải dữ liệu...")
            } else {
                task.value?.let {
                    Text(text = "📌 ${it.title ?: "(Không có tiêu đề)"}", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "📅 Ngày hết hạn: ${it.dueDate ?: "(Không có dữ liệu)"}", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "⚡ Mức độ ưu tiên: ${it.priority ?: "(Không có dữ liệu)"}", style = MaterialTheme.typography.bodyMedium)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    Text(text = it.description ?: "(Không có mô tả)", style = MaterialTheme.typography.bodySmall)
                } ?:  Image(
                    painter = painterResource(id = R.drawable.group_17),
                    contentDescription = "Không tìm thấy công việc",
                    modifier = Modifier.fillMaxSize()
                        .size(width = 350.dp, height = 255.dp)
                        .padding(start = 2.dp, top = 5.dp)

                )
            }
        }
    }
}
