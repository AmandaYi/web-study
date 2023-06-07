#pragma once


// MFC01DialogShow 对话框

class MFC01DialogShow : public CDialogEx
{
	DECLARE_DYNAMIC(MFC01DialogShow)

public:
	MFC01DialogShow(CWnd* pParent = nullptr);   // 标准构造函数
	virtual ~MFC01DialogShow();

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_SHOW };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

	DECLARE_MESSAGE_MAP()
};
