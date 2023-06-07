#pragma once


// TAB_LEFT 对话框

class TAB_LEFT : public CDialogEx
{
	DECLARE_DYNAMIC(TAB_LEFT)

public:
	TAB_LEFT(CWnd* pParent = nullptr);   // 标准构造函数
	virtual ~TAB_LEFT();

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_TAB_LEFT };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

	DECLARE_MESSAGE_MAP()
};
