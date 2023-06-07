
// mfc04comboBoxSelectDlg.h: 头文件
//

#pragma once


// Cmfc04comboBoxSelectDlg 对话框
class Cmfc04comboBoxSelectDlg : public CDialogEx
{
// 构造
public:
	Cmfc04comboBoxSelectDlg(CWnd* pParent = nullptr);	// 标准构造函数

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_MFC04COMBOBOXSELECT_DIALOG };
#endif

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV 支持


// 实现
protected:
	HICON m_hIcon;

	// 生成的消息映射函数
	virtual BOOL OnInitDialog();
	void InitSelf();

	

	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
private:
	CComboBox select1;
public:
	afx_msg void OnCbnSelchangeCombo1();
	afx_msg void OnBnClickedButton1();
private:
	CButton select1btn1;
public:
	afx_msg void OnBnClickedButton2();
private:
	CButton select1btn2;
public:
	afx_msg void OnBnClickedButton4();
	CString Cmfc04comboBoxSelectDlg::GetCurSelContent();
};
