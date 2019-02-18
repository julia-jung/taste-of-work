package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.A_MemberDao;
import model.vo.A_Member;
import view.A_LoginPage;
import view.A_MainPage;

import view.ChangePanel;
import view.MainFrame;

public class A_MemberManager {
	private MainFrame mf;
	private A_MemberDao md = new A_MemberDao();
	private A_LoginPage lp;
	
	public void joinMember(A_Member a_Member) {
		
		//���Ͽ� ��ϵ� ����Ʈ ��ȸ
		ArrayList<A_Member> list = md.readMemberList();
		
		//
		if(list==null) {
			
			list = new ArrayList<A_Member>();
		}
		//����Ʈ�� member ��ü �߰�
		list.add(a_Member);
		
		//����Ʈ�� ���Ͽ� ��� �� ����� ������ ����
		int result = md.writeMemberList(list);
		
		
	}
	
	
	public void loginMember(String id, String pwd, A_LoginPage lp) {
		this.lp = lp;
		//��ü ����� ��ȸ
		ArrayList<A_Member> list = md.readMemberList();
		
		for(int i = 0 ; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		if(list==null) {
			JOptionPane.showMessageDialog(null, "���̵�/��й�ȣ�� �Է����ּ���");
			
		}
		
		if(list != null) {
			if( id.equals(" ")&& (pwd.equals(" "))) {
				JOptionPane.showMessageDialog(null, "���̵�/��й�ȣ�� �Է����ּ���");
				return;
			
			}else{
				
				for(int i =0; i<list.size(); i++) {
			
				if(list.get(i).getId().equals(id) && list.get(i).getPwd().equals(pwd)) {
					lp.goToMainPage(lp);
					return;
					}else if(id.equals(" ")&& (pwd.equals(" "))) {
						JOptionPane.showMessageDialog(null, "���̵�/��й�ȣ�� �Է����ּ���");
						return;
					}
				}
				for(int i =0; i<list.size(); i++) {
					if(list.get(i).getId() != id && list.get(i).getPwd()!= pwd) {
						
						JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ȯ���ϼ���"); 
						return;
						
						
					}else if(list.get(i).getId() == " " && list.get(i).getPwd()== " "){
						JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է��ϼ���");
						return;
					}
				}
			}
			
			
		}
		
	}
	
	public void idcheck(String id) {
		ArrayList<A_Member> list = md.readMemberList();
		if(list==null) {
			if(id != "") {
			JOptionPane.showMessageDialog(null, "����� �� �ִ� ���̵� �Դϴ�.");
			list = new ArrayList<A_Member>();
			}else if(id==""){
				JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.");
				list = new ArrayList<A_Member>();
			}
		}
		
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "������� ���̵� �Դϴ�.");
				return;
			}
			
		}
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getId() != id){
			
			JOptionPane.showMessageDialog(null, "����� �� �ִ� ���̵� �Դϴ�.");
				return;
			
		}
		}
	}
   
	public void findId(String name, String phone, String email) {
		
		ArrayList<A_Member> list = md.readMemberList();
		
		if(list==null) {
			JOptionPane.showMessageDialog(null, "����� ������ Ȯ�����ּ���");
			list = new ArrayList<A_Member>();
		}
		
		
		for(int i =0; i<list.size(); i++) {
			
			if(list.get(i).getName().equals(name) 
					&& list.get(i).getPhone().equals(phone) 
					&& list.get(i).getEmail().equals(email)) {
				
				JOptionPane.showMessageDialog(null, name+"���� ���̵��" +list.get(i).getId()+ "�Դϴ�");
				return;
			}
		}
			
			
			JOptionPane.showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�.");
				
	
		}
	public void findPwd(String id, String phone, String email) {
		ArrayList<A_Member> list = md.readMemberList();
		
		if(list==null) {
			JOptionPane.showMessageDialog(null, "����� ������ Ȯ�����ּ���");
			list = new ArrayList<A_Member>();
		
		}else {
		
		for(int i =0; i<list.size(); i++) {
			
			if(list.get(i).getId().equals(id) 
					&& list.get(i).getPhone().equals(phone) 
					&& list.get(i).getEmail().equals(email)) {
				
				JOptionPane.showMessageDialog(null, list.get(i).getName()+"���� ��й�ȣ��" +list.get(i).getPwd()+ "�Դϴ�");
				return;
			
			}
			
		}
		JOptionPane.showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�.");
	}	
				
	
		}
	
}


