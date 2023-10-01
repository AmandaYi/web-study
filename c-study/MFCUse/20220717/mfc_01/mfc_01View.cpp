
// mfc_01View.cpp: Cmfc01View 类的实现
//

#include "pch.h"
#include "framework.h"
// SHARED_HANDLERS 可以在实现预览、缩略图和搜索筛选器句柄的
// ATL 项目中进行定义，并允许与该项目共享文档代码。
#ifndef SHARED_HANDLERS
#include "mfc_01.h"
#endif

#include "mfc_01Doc.h"
#include "mfc_01View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// Cmfc01View

IMPLEMENT_DYNCREATE(Cmfc01View, CView)

BEGIN_MESSAGE_MAP(Cmfc01View, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
//	ON_WM_MBUTTONDOWN()
ON_WM_LBUTTONDOWN()
END_MESSAGE_MAP()

// Cmfc01View 构造/析构

Cmfc01View::Cmfc01View() noexcept
{
	// TODO: 在此处添加构造代码

}

Cmfc01View::~Cmfc01View()
{
}

BOOL Cmfc01View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// Cmfc01View 绘图

void Cmfc01View::OnDraw(CDC* /*pDC*/)
{
	Cmfc01Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码
}


// Cmfc01View 打印

BOOL Cmfc01View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void Cmfc01View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void Cmfc01View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}


// Cmfc01View 诊断

#ifdef _DEBUG
void Cmfc01View::AssertValid() const
{
	CView::AssertValid();
}

void Cmfc01View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

Cmfc01Doc* Cmfc01View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(Cmfc01Doc)));
	return (Cmfc01Doc*)m_pDocument;
}
#endif //_DEBUG


// Cmfc01View 消息处理程序


//void Cmfc01View::OnMButtonDown(UINT nFlags, CPoint point)
//{
//	// TODO: 在此添加消息处理程序代码和/或调用默认值
//
//	CView::OnMButtonDown(nFlags, point);
//	CString str = TEXT("你好");
//	MessageBox(str);
//}


void Cmfc01View::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	CView::OnLButtonDown(nFlags, point);

	CString str = TEXT("GO");
	MessageBox(str);

}
