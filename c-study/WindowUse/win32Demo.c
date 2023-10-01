#include <windows.h>


LRESULT CALLBACK WinProc(
	HWND hwnd, 
	UINT uMsg, 
	WPARAM wParam, 
	LPARAM lParam 
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

		wsprintf((LPWSTR)buf, TEXT("窗口位置 x = %d; y = %d"), xPos, yPos);
		MessageBox(hwnd, (LPWSTR)buf, TEXT("֪ͨ"), MB_OK);
		break; 
	}
	case WM_KEYDOWN: {
		MessageBox(hwnd, TEXT("keydown"), TEXT("֪ͨ"), MB_OK);
		break;
	}
	case WM_PAINT: {
		PAINTSTRUCT ps;
		HDC hdc = BeginPaint(hwnd, &ps);
		
		TextOut(hdc, 100, 200, TEXT("Paint"), strlen("99999"));

		EndPaint(hwnd, &ps);

		break;	
	}
	default:
		break;
	}



	
	return DefWindowProc(hwnd, uMsg, wParam, lParam);
}

int WINAPI WinMain(
	HINSTANCE hInstance, 
	HINSTANCE hPrevInstance, 
	LPSTR lpCmdLine,  
	int nShowCmd 
) {
	
	WNDCLASS wc;
	wc.cbClsExtra = 0; 
	wc.cbWndExtra = 0; 
	wc.hbrBackground = (HBRUSH) GetStockObject(LTGRAY_BRUSH); 
	wc.hCursor = LoadCursor(NULL, IDC_HAND); 
	wc.hIcon = LoadIcon(NULL, IDI_WINLOGO); 
	wc.hInstance = hInstance; 
	wc.lpfnWndProc = WinProc; 

	wc.lpszClassName = TEXT("win32_01"); 
	wc.lpszMenuName = NULL; 
	wc.style = 0; 



	
	RegisterClass(&wc);

	HWND hwnd = CreateWindow(wc.lpszClassName,TEXT("Win32_2022"),WS_OVERLAPPEDWINDOW, CW_USEDEFAULT, CW_USEDEFAULT,CW_USEDEFAULT,CW_USEDEFAULT,NULL,NULL,hInstance,NULL);
		;

   
		ShowWindow(hwnd, SW_SHOWNORMAL);
		UpdateWindow(hwnd);

		
		MSG msg;

		while (1)
		{
			if (GetMessage(&msg, hwnd, 0, 0) == FALSE) {
				break;
			}

			TranslateMessage(&msg); 
			DispatchMessage(&msg); 
		}
		
	return 0;
}