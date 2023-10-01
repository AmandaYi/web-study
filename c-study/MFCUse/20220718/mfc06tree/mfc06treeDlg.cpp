
// mfc06treeDlg.cpp: 实现文件
//

#include "pch.h"
#include "framework.h"
#include "mfc06tree.h"
#include "mfc06treeDlg.h"
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


// Cmfc06treeDlg 对话框



Cmfc06treeDlg::Cmfc06treeDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_MFC06TREE_DIALOG, pParent)
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void Cmfc06treeDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Control(pDX, IDC_TREE1, m_tree);
	DDX_Control(pDX, IDC_CURRENT_TEXT, current_text);
}

BEGIN_MESSAGE_MAP(Cmfc06treeDlg, CDialogEx)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_NOTIFY(TVN_SELCHANGED, IDC_TREE1, &Cmfc06treeDlg::OnTvnSelchangedTree1)
END_MESSAGE_MAP()


// Cmfc06treeDlg 消息处理程序

BOOL Cmfc06treeDlg::OnInitDialog()
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
	SelfInit();

	return TRUE;  // 除非将焦点设置到控件，否则返回 TRUE
}

void Cmfc06treeDlg::SelfInit() {

	HICON icons[4];
	icons[0] = AfxGetApp()->LoadIconW(IDI_ICON1);
	icons[1] = AfxGetApp()->LoadIconW(IDI_ICON2);
	icons[2] = AfxGetApp()->LoadIconW(IDI_ICON3);
	icons[3] = AfxGetApp()->LoadIconW(IDI_ICON4);

	// CImageList imgList;  // 应该设置为成员变量
	imgList.Create(30, 30, ILC_COLOR32, 4, 4);
	imgList.Add(icons[0]);
	imgList.Add(icons[1]);
	imgList.Add(icons[2]);
	imgList.Add(icons[3]);

	// 把当前树的全部需要的图标都先放进来一个图标数组里面
	m_tree.SetImageList(&imgList, TVSIL_NORMAL);
	// 修改节点间的位置，同时设置展开节点和折叠节点时的图标样子，同时设置父节点的句柄。
	HTREEITEM	root = m_tree.InsertItem(TEXT("根节点"), 0, 0, NULL);
	HTREEITEM parent = m_tree.InsertItem(TEXT("父节点"), 1, 1, root);
	HTREEITEM sub1 = m_tree.InsertItem(TEXT("子节点1"), 2, 2, parent);
	HTREEITEM sub2 = m_tree.InsertItem(TEXT("子节点2"), 3, 3, root);
	// 设置默认值
	m_tree.SelectItem(sub2);
}
void Cmfc06treeDlg::OnSysCommand(UINT nID, LPARAM lParam)
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

void Cmfc06treeDlg::OnPaint()
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
HCURSOR Cmfc06treeDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}


// 节点树改变后，触发的事件
void Cmfc06treeDlg::OnTvnSelchangedTree1(NMHDR* pNMHDR, LRESULT* pResult)
{
	LPNMTREEVIEW pNMTreeView = reinterpret_cast<LPNMTREEVIEW>(pNMHDR);
	// TODO: 在此添加控件通知处理程序代码
	*pResult = 0;

	// 获取当前的节点
	HTREEITEM currentSelect = m_tree.GetSelectedItem();
	// 获取当前节点的文本内容
	CString currentSelectText = m_tree.GetItemText(currentSelect);
	// 设置静态展示文本的内容
	current_text.SetWindowTextW(currentSelectText);
}
