#include "mfc.h"

MyApp app; // 全局应用对象，有且只有一个

BOOL MyApp::InitInstance()
{
	// 创建对象
	MyFrame * frame = new MyFrame();
	// 展示和更新
	frame -> ShowWindow(SW_SHOWNORMAL);
	frame-> UpdateWindow();

	m_pMainWnd = frame; // 保存指向主句柄的指针
	return TRUE;
}

//分界宏
BEGIN_MESSAGE_MAP(MyFrame, CFrameWnd) // 指定消息映射所属的类的名字

	ON_WM_LBUTTONDOWN()

END_MESSAGE_MAP() //

MyFrame::MyFrame()
{
	Create(NULL, TEXT("win32_02"));
}

void MyFrame::OnLButtonDown(UINT, CPoint point)
{
	TCHAR buf[1024]; 
	wsprintf(buf, TEXT("x = %d, y = %d"), point.x, point.y);
	MessageBox(buf);
}

