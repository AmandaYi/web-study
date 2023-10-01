
// mfc06treeDlg.h: 头文件
//

#pragma once


// Cmfc06treeDlg 对话框
class Cmfc06treeDlg : public CDialogEx
{
// 构造
public:
	Cmfc06treeDlg(CWnd* pParent = nullptr);	// 标准构造函数

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_MFC06TREE_DIALOG };
#endif

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV 支持


// 实现
protected:
	HICON m_hIcon;

	// 生成的消息映射函数
	virtual BOOL OnInitDialog();
	afx_msg
		void SelfInit();
	void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
private:
	CTreeCtrl m_tree;
public:
	afx_msg void OnTvnSelchangedTree1(NMHDR* pNMHDR, LRESULT* pResult);
private:
	// 静态文本空间的变量句柄
	CStatic current_text;
	// 节点树需要的全部图标列表，方便m_tree直接调用
	CImageList imgList;
};
