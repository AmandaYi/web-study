
// mfc03edittextDlg.h: 头文件
//

#pragma once


// Cmfc03edittextDlg 对话框
class Cmfc03edittextDlg : public CDialogEx
{
// 构造
public:
	Cmfc03edittextDlg(CWnd* pParent = nullptr);	// 标准构造函数

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_MFC03EDITTEXT_DIALOG };
#endif

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV 支持


// 实现
protected:
	HICON m_hIcon;

	// 生成的消息映射函数
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
private:
	CEdit input1_1;
public:
	CEdit input1_2;
	afx_msg void OnBnClickedButton1();
	afx_msg void OnBnClickedButton2();
//	CEdit input2_1;
//	CEdit input2_2;
//	CEdit input3_1;
private:
//	CString input2_2;
	CString input2_1;
	CString input2_2;
	CString input3_1;
public:
	afx_msg void OnBnClickedButton3();
	afx_msg void OnBnClickedButton4();
	afx_msg void OnBnClickedButton5();
};
