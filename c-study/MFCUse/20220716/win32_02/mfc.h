#include <afxwin.h>

class MyApp :public CWinApp // CWinApp应用程序
{
public:
	// 程序入口
	virtual BOOL InitInstance();
};

class MyFrame :public CFrameWnd // 窗口框架
{
public:

	MyFrame();

	// 声明宏，提供消息映射机制
	DECLARE_MESSAGE_MAP();

	afx_msg void OnLButtonDown(UINT, CPoint);
};
