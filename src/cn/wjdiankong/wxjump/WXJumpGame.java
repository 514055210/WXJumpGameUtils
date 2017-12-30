package cn.wjdiankong.wxjump;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class WXJumpGame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private PhoneImagePanel phoneImgPanel = null;
	private boolean isFirst = true;
	private Point prePoint = new Point();
	private Point curPoint = new Point();

	public WXJumpGame(){
		phoneImgPanel = new PhoneImagePanel();
		this.add(phoneImgPanel);
		this.setSize(540, 960);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//��ͼ��������������¼�
		phoneImgPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent event) {
				//ÿ��������֮ǰ����Ҫ��������������㣬Ҳ�������ĵ�
				if(isFirst){
					prePoint.x = event.getX();
					prePoint.y = event.getY();
					isFirst = false;
					return;
				}
				curPoint.x = event.getX();
				curPoint.y = event.getY();
				//ʹ�ù��ɶ��������Ծ�ľ���
				int distance = Utils.calDistance(prePoint, curPoint);
				//�����ֵ����Ҫ�ֶ���������ģ�ÿ���ֻ��ߴ����һ������Ҫ�Լ��ֶ�����
				int time = (int)(distance/0.37);
				Utils.jump(time);
				System.out.println("distance:"+distance+",time:"+time);
				//�����ʱ����Ϊ�˵ȴ���ͼ����ͼƬ������У�ʱ��Ҳ����Ҫ�Լ��趨����Ȼͼ����ƻ���ִ���
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//Ϊ����һ���ܹ����������
				isFirst = true;
				//�����ˣ��Ϳ�ʼˢ����壬��ȡ���µ��ֻ���Ļ��Ϣ
				phoneImgPanel.validate();
				phoneImgPanel.repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent event) {
			}
			
			@Override
			public void mouseExited(MouseEvent event) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent event) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent event) {
				
			}
		});
	}

	public static void main(String[] args){
		new WXJumpGame();
	}

}

