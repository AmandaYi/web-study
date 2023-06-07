
// mfc03edittextDlg.cpp: 实现文件
//

#include "pch.h"
#include "framework.h"
#include "mfc03edittext.h"
#include "mfc03edittextDlg.h"
#include "afxdialogex.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// 用于应用程序“关于”菜单项的 CAboutDlg 对话框

class CAboutDlg : public CDialogEx
{
public:
	CAboutDlg();

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_ABOUTBOX };
#endif

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

// 实现
protected:
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialogEx(IDD_ABOUTBOX)
{
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialogEx)
END_MESSAGE_MAP()


// Cmfc03edittextDlg 对话框



Cmfc03edittextDlg::Cmfc03edittextDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_MFC03EDITTEXT_DIALOG, pParent)
	
	, input2_1(_T(""))
	, input2_2(_T(""))
	, input3_1(_T(""))
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void Cmfc03edittextDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Control(pDX, IDC_EDIT1, input1_1);
	DDX_Control(pDX, IDC_EDIT3, input1_2);
	//  DDX_Control(pDX, IDC_EDIT4, input2_1);
	//  DDX_Control(pDX, IDC_EDIT2, input2_2);
	//  DDX_Control(pDX, IDC_EDIT5, input3_1);
	//  DDX_Text(pDX, IDC_EDIT4, input2_2);
	DDX_Text(pDX, IDC_EDIT4, input2_1);
	DDX_Text(pDX, IDC_EDIT2, input2_2);
	DDX_Text(pDX, IDC_EDIT5, input3_1);
}

BEGIN_MESSAGE_MAP(Cmfc03edittextDlg, CDialogEx)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BUTTON1, &Cmfc03edittextDlg::OnBnClickedButton1)
	ON_BN_CLICKED(IDC_BUTTON2, &Cmfc03edittextDlg::OnBnClickedButton2)
	ON_BN_CLICKED(IDC_BUTTON3, &Cmfc03edittextDlg::OnBnClickedButton3)
	ON_BN_CLICKED(IDC_BUTTON4, &Cmfc03edittextDlg::OnBnClickedButton4)
	ON_BN_CLICKED(IDC_BUTTON5, &Cmfc03edittextDlg::OnBnClickedButton5)
END_MESSAGE_MAP()


// Cmfc03edittextDlg 消息处理程序

BOOL Cmfc03edittextDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	// 将“关于...”菜单项添加到系统菜单中。

	// IDM_ABOUTBOX 必须在系统命令范围内。
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != nullptr)
	{
		BOOL bNameValid;
		CString strAboutMenu;
		bNameValid = strAboutMenu.LoadString(IDS_ABOUTBOX);
		ASSERT(bNameValid);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

	// 设置此对话框的图标。  当应用程序主窗口不是对话框时，框架将自动
	//  执行此操作
	SetIcon(m_hIcon, TRUE);			// 设置大图标
	SetIcon(m_hIcon, FALSE);		// 设置小图标

	// TODO: 在此添加额外的初始化代码

	return TRUE;  // 除非将焦点设置到控件，否则返回 TRUE
}

void Cmfc03edittextDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialogEx::OnSysCommand(nID, lParam);
	}
}

// 如果向对话框添加最小化按钮，则需要下面的代码
//  来绘制该图标。  对于使用文档/视图模型的 MFC 应用程序，
//  这将由框架自动完成。

void Cmfc03edittextDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // 用于绘制的设备上下文

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// 使图标在工作区矩形中居中
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// 绘制图标
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialogEx::OnPaint();
	}
}

//当用户拖动最小化窗口时系统调用此函数取得光标
//显示。
HCURSOR Cmfc03edittextDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}


// 复制input1_1的内容到input1_2
void Cmfc03edittextDlg::OnBnClickedButton1()
{
	// TODO: 在此添加控件通知处理程序代码
	CString str;
	input1_1.GetWindowTextW(str);
	input1_2.SetWindowTextW(str);
}

// 复制input2_1的内容到input2_2
void Cmfc03edittextDlg::OnBnClickedButton2()
{
	// TODO: 在此添加控件通知处理程序代码

	// 获取input2_1的内容
	UpdateData(TRUE);
	CString s = input2_1;

	input2_2 = s;
	UpdateData(FALSE);
}

// 设置值形式的input3_1
void Cmfc03edittextDlg::OnBnClickedButton3()
{
	// TODO: 在此添加控件通知处理程序代码

	input3_1 = "我是值形式的";
	// 更新代码到界面
	UpdateData(FALSE);
}

// 得到值形式的input3_1
void Cmfc03edittextDlg::OnBnClickedButton4()
{
	// TODO: 在此添加控件通知处理程序代码

	// 首先把空间里面的值更新到代码里面，然后再获取值
	UpdateData(TRUE);
	MessageBox(input3_1);
}

// 退出当前对话框
void Cmfc03edittextDlg::OnBnClickedButton5()
{
	// TODO: 在此添加控件通知处理程序代码


	// 退出整个程序
	// exit(0); // 这里参数无所谓
	// 退出当前的对话框
	CDialogEx::OnOK();
	// CDialogEx::OnCancel();
}
