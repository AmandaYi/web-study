#include <windows.h>


LRESULT CALLBACK WinProc(
	HWND hwnd, // 消息所属的句柄
	UINT uMsg, // 消息的类型
	WPARAM wParam, // 键盘附加参数
	LPARAM lParam // 鼠标附加参数
) {

	switch (uMsg)
	{
	case WM_CLOSE:
	{
		DestroyWindow(hwnd);
		break; 
	}
	case WM_DESTROY:
	{
		PostQuitMessage(0);
		break; 
	}
	case WM_LBUTTONDOWN:
	{
		int xPos = LOWORD(lParam);
		int yPos = HIWORD(lParam);
		char buf[1024];

		wsprintf((LPWSTR)buf, TEXT("鼠标左键按下了 x = %d; y = %d"), xPos, yPos);
		MessageBox(hwnd, (LPWSTR)buf, TEXT("通知"), MB_OK);
		break; 
	}
	case WM_KEYDOWN: {
		MessageBox(hwnd, TEXT("键盘按下了"), TEXT("通知"), MB_OK);
		break;
	}
	case WM_PAINT: {
		PAINTSTRUCT ps;
		HDC hdc = BeginPaint(hwnd, &ps);
		
		TextOut(hdc, 100, 200, TEXT("你好菜狗"), strlen("99999"));

		EndPaint(hwnd, &ps);

		break;	
	}
	default:
		break;
	}



	//返回值默认处理
	return DefWindowProc(hwnd, uMsg, wParam, lParam);
}

int WINAPI WinMain(
	HINSTANCE hInstance, // 当前句柄
	HINSTANCE hPrevInstance, // 上一个窗口的句柄，一般不用了
	LPSTR lpCmdLine,  // 命令行参数 char *argv[]
	int nShowCmd // 最大化，最小化等操作
) {

	/*
	1. 设计窗口
	2. 注册窗口
	3. 创建窗口
	4. 显示和更新窗口
	5. 通过循环取消息
	6. 处理消息（窗口的过程）
	*/

	//1. 设计窗口
	WNDCLASS wc;
	wc.cbClsExtra = 0; // 类不需要额外的内存
	wc.cbWndExtra = 0; // 窗口不需要额外的内存
	wc.hbrBackground = (HBRUSH) GetStockObject(LTGRAY_BRUSH); // 背景
	wc.hCursor = LoadCursor(NULL, IDC_HAND); // 光标外观
	wc.hIcon = LoadIcon(NULL, IDI_WINLOGO); // 图标左上角的那个
	wc.hInstance = hInstance; // 当前程序句柄
	wc.lpfnWndProc = WinProc; // 当前事件循环消息的处理函数

	wc.lpszClassName = TEXT("win32_01"); // 窗口类的名称
	wc.lpszMenuName = NULL; // 菜单名称
	wc.style = 0; // 风格，0 默认风格



	//2. 注册窗口
	RegisterClass(&wc);

	//3. 创建窗口
	/*	lpClassName, 类名
		lpWindowName,  就是窗口的名字
		dwStyle,  风格
		x, 坐标
		y, 		
		nWidth, 宽高 
		nHeight, 
		hWndParent, 父窗口
		hMenu,  菜单
		hInstance, 实例
		lpParam 鼠标附加值
	*/
	HWND hwnd = CreateWindow(wc.lpszClassName,TEXT("Win32_2022"),WS_OVERLAPPEDWINDOW, CW_USEDEFAULT, CW_USEDEFAULT,CW_USEDEFAULT,CW_USEDEFAULT,NULL,NULL,hInstance,NULL);
		;

   //4. 展示
		ShowWindow(hwnd, SW_SHOWNORMAL);
		UpdateWindow(hwnd);

		//5. 循环消息
		MSG msg;

		while (1)
		{
			if (GetMessage(&msg, hwnd, 0, 0) == FALSE) {
				break;
			}

			TranslateMessage(&msg); // 自动翻译快捷键
			DispatchMessage(&msg); // 分发消息到消息队列
		}


		//6. 事件处理函数


	return 0;
}