#pragma once


// MFC01DialogExec 对话框

class MFC01DialogExec : public CDialogEx
{
	DECLARE_DYNAMIC(MFC01DialogExec)

public:
	MFC01DialogExec(CWnd* pParent = nullptr);   // 标准构造函数
	virtual ~MFC01DialogExec();

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_EXEC };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

	DECLARE_MESSAGE_MAP()
};
