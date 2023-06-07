#include <windows.h>


LRESULT CALLBACK WinProc(
	HWND hwnd, // ��Ϣ�����ľ��
	UINT uMsg, // ��Ϣ������
	WPARAM wParam, // ���̸��Ӳ���
	LPARAM lParam // ��긽�Ӳ���
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

		wsprintf((LPWSTR)buf, TEXT("������������ x = %d; y = %d"), xPos, yPos);
		MessageBox(hwnd, (LPWSTR)buf, TEXT("֪ͨ"), MB_OK);
		break; 
	}
	case WM_KEYDOWN: {
		MessageBox(hwnd, TEXT("���̰�����"), TEXT("֪ͨ"), MB_OK);
		break;
	}
	case WM_PAINT: {
		PAINTSTRUCT ps;
		HDC hdc = BeginPaint(hwnd, &ps);
		
		TextOut(hdc, 100, 200, TEXT("��ò˹�"), strlen("99999"));

		EndPaint(hwnd, &ps);

		break;	
	}
	default:
		break;
	}



	//����ֵĬ�ϴ���
	return DefWindowProc(hwnd, uMsg, wParam, lParam);
}

int WINAPI WinMain(
	HINSTANCE hInstance, // ��ǰ���
	HINSTANCE hPrevInstance, // ��һ�����ڵľ����һ�㲻����
	LPSTR lpCmdLine,  // �����в��� char *argv[]
	int nShowCmd // ��󻯣���С���Ȳ���
) {

	/*
	1. ��ƴ���
	2. ע�ᴰ��
	3. ��������
	4. ��ʾ�͸��´���
	5. ͨ��ѭ��ȡ��Ϣ
	6. ������Ϣ�����ڵĹ��̣�
	*/

	//1. ��ƴ���
	WNDCLASS wc;
	wc.cbClsExtra = 0; // �಻��Ҫ������ڴ�
	wc.cbWndExtra = 0; // ���ڲ���Ҫ������ڴ�
	wc.hbrBackground = (HBRUSH) GetStockObject(LTGRAY_BRUSH); // ����
	wc.hCursor = LoadCursor(NULL, IDC_HAND); // ������
	wc.hIcon = LoadIcon(NULL, IDI_WINLOGO); // ͼ�����Ͻǵ��Ǹ�
	wc.hInstance = hInstance; // ��ǰ������
	wc.lpfnWndProc = WinProc; // ��ǰ�¼�ѭ����Ϣ�Ĵ�����

	wc.lpszClassName = TEXT("win32_01"); // �����������
	wc.lpszMenuName = NULL; // �˵�����
	wc.style = 0; // ���0 Ĭ�Ϸ��



	//2. ע�ᴰ��
	RegisterClass(&wc);

	//3. ��������
	/*	lpClassName, ����
		lpWindowName,  ���Ǵ��ڵ�����
		dwStyle,  ���
		x, ����
		y, 		
		nWidth, ��� 
		nHeight, 
		hWndParent, ������
		hMenu,  �˵�
		hInstance, ʵ��
		lpParam ��긽��ֵ
	*/
	HWND hwnd = CreateWindow(wc.lpszClassName,TEXT("Win32_2022"),WS_OVERLAPPEDWINDOW, CW_USEDEFAULT, CW_USEDEFAULT,CW_USEDEFAULT,CW_USEDEFAULT,NULL,NULL,hInstance,NULL);
		;

   //4. չʾ
		ShowWindow(hwnd, SW_SHOWNORMAL);
		UpdateWindow(hwnd);

		//5. ѭ����Ϣ
		MSG msg;

		while (1)
		{
			if (GetMessage(&msg, hwnd, 0, 0) == FALSE) {
				break;
			}

			TranslateMessage(&msg); // �Զ������ݼ�
			DispatchMessage(&msg); // �ַ���Ϣ����Ϣ����
		}


		//6. �¼�������


	return 0;
}