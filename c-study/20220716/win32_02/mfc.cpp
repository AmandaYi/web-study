#include "mfc.h"

MyApp app; // ȫ��Ӧ�ö�������ֻ��һ��

BOOL MyApp::InitInstance()
{
	// ��������
	MyFrame * frame = new MyFrame();
	// չʾ�͸���
	frame -> ShowWindow(SW_SHOWNORMAL);
	frame-> UpdateWindow();

	m_pMainWnd = frame; // ����ָ���������ָ��
	return TRUE;
}

//�ֽ��
BEGIN_MESSAGE_MAP(MyFrame, CFrameWnd) // ָ����Ϣӳ���������������

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

