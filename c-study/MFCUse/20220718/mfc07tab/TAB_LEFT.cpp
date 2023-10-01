// TAB_LEFT.cpp: 实现文件
//

#include "pch.h"
#include "mfc07tab.h"
#include "TAB_LEFT.h"
#include "afxdialogex.h"


// TAB_LEFT 对话框

IMPLEMENT_DYNAMIC(TAB_LEFT, CDialogEx)

TAB_LEFT::TAB_LEFT(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_TAB_LEFT, pParent)
{

}

TAB_LEFT::~TAB_LEFT()
{
}

void TAB_LEFT::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}


BEGIN_MESSAGE_MAP(TAB_LEFT, CDialogEx)
END_MESSAGE_MAP()


// TAB_LEFT 消息处理程序
