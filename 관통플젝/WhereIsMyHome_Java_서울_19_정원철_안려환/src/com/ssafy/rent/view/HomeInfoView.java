package com.ssafy.rent.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ssafy.rent.WhereIsMyHomeException;
import com.ssafy.rent.model.dto.EnvPollution;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomePageBean;
import com.ssafy.rent.model.service.EnvPollutionService;
import com.ssafy.rent.model.service.HomeService;
import com.ssafy.rent.model.service.HomeServiceImpl;


public class HomeInfoView{
	
	/**model들 */
	private HomeService 		homeService;
	private EnvPollutionService envpService;
	
	/** main 화면 */
	private JFrame frame;
	
	/** 주택 목록 화면*/
	// JFrame owner;
	

	/**창 닫기 버튼*/
	//private JButton  closeBt;
	
	/**주택 이미지 표시 Panel*/
	private JLabel	 			imgL;
	private JLabel[] 			homeInfoL;
	
	/**조회 조건*/
	private JCheckBox[]		  	chooseC;
	private JComboBox<String> 	findC; 
	private JTextField		  	wordTf;
	private JButton			  	searchBt;
	
	/**조회 내용 표시할 table*/
	private DefaultTableModel 	homeModel;
	private JTable			  	homeTable;
	private JScrollPane		  	homePan;
	private String[]		  	title = { "번호", "동", "아파트이름", "거래금액", "거래종류" };
	
	
	
	
	/**조회 내용 표시할 table*/
	private DefaultTableModel envpModel;
	private JTable envpTable;
	private JScrollPane envpPane;
	private String[] envpTitle = { "측정일시", "측정소명", "이산화질소", "오존", "일산화탄소", "아황산가스", "미세먼지", "초미세먼지" };
	
	/**조회 내용 표시할 table*/
	private DefaultTableModel convModel;
	private JTable convTable;
	private JScrollPane convPane;
	private String[] convTitle = { "주소", "이름", "업종" };
	
	
	
	
	
	
	
	
	
	/**검색  조건*/
	private String	key;
	
	/**검색할 단어*/
	private String  word;
	private boolean[] searchType = { true, true, true, true };
	private String[] choice = { "all", "dong", "name" };
	
	/**화면에 표시하고 있는 주택*/
	private HomeDeal curHome;

	
	private void showHomeInfo(int code) {
		
		curHome = homeService.search(code);
		System.out.println(curHome);
		
		//@주석 처리 되어있던곳 1
//		foodInfoL[0].setText(""+curfood.getCode());
		
		
		
		homeInfoL[0].setText("");
		homeInfoL[1].setText("");
		homeInfoL[2].setText(curHome.getAptName());
		homeInfoL[3].setText(""+curHome.getDealAmount());
		String rent = curHome.getRentMoney();
		if(rent == null) {
			homeInfoL[4].setText("없음");
		}else {
			homeInfoL[4].setText(curHome.getRentMoney());
		}
		homeInfoL[5].setText(""+curHome.getBuildYear());
		homeInfoL[6].setText(curHome.getArea()+"");
		homeInfoL[7].setText(String.format("%d년 %d월 %d일"
											,curHome.getDealYear()
											,curHome.getDealMonth()
											,curHome.getDealDay()
											));
		homeInfoL[8].setText(curHome.getDong());
		homeInfoL[9].setText(curHome.getJibun());
		
		
		setImage();
		
//		System.out.println("###############" + curHome.getImg());
		
//		
//		ImageIcon icon = null;
//		if( curHome.getImg() != null && curHome.getImg().trim().length() != 0) {
//			icon = new ImageIcon("img/" + curHome.getImg());
//			System.out.println("#####" + icon.toString() + "####");
//		}else {
//			icon = new ImageIcon("img/다세대주택.jpg");
//		}
//
//		imgL.setIcon(icon);
		  
		  

//@주석 처리 되어있던곳 2
//		Image img = null;
//		try {
//			img = ImageIO.read(new File("img/"+curHome.getImg()));
//         } catch (IOException ex) {
//        	 try {
//        		 img = ImageIO.read(new File("img/다세대주택.jpg"));
//			} catch (Exception e) {
//			}
//         }
//		img = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		imgL.setIcon(new ImageIcon(img));
	}
	
	
	// 새로 정의한 함수
	public void setImage() {
		String buidingImgs[] = {"건양하늘터", "경희궁의아침", "광화문풍림스페이스본", "교복동경희궁자이(4단지)", "다세대주택", "동성아파트", "무악동인왕산아이파크", "무악동현대", "송인동롯데캐슬천지인", 
				"신동아블루아광화문", "아남1", "창신동덕산", "창신동두산", "창신동창신쌍용1", "창신동창신쌍용2", "평동경희궁자이(3단지)", "평창동갑을", 
				"현대뜨레비앙", "홍파동경희궁자이(2단지)", };
		
		Image img = null;
		String imgSourceName=null;
		try {		
			for(String imgName: buidingImgs) {
				
			if (imgName.length()<=curHome.getAptName().length()) {
				if(curHome.getAptName().contains(imgName)){
					imgSourceName=imgName+".jpg";
				}
			}else {
				if(imgName.contains(curHome.getAptName())){
					imgSourceName=imgName+".jpg";
				}
			}
				
		}
		
			img = ImageIO.read(new File("img/"+imgSourceName));
         } catch (IOException ex) {
        	 try {
        		 img = ImageIO.read(new File("img/다세대주택.jpg"));
			} catch (Exception e) {
			}
         }
		img = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		imgL.setIcon(new ImageIcon(img));
	}
	
	


	
	
	
	public HomeInfoView(){
		/*Service들 생성 */
		homeService = new HomeServiceImpl();
		
		/*메인 화면 설정 */
		frame = new JFrame("WhereIsMyHome -- 아파트 거래 정보");

		
		
		//@주석 처리 되어있던곳 3
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				frame.dispose();
			}
		});
	
		
		
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showHomeInfo(1);
		//showHomes();
	}

	/**메인 화면인 주택 목록을 위한 화면 셋팅하는 메서드  */
	public void setMain(){
		
		/*왼쪽 화면을 위한 설정 */
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftCenter = new JPanel(new GridLayout(1, 2));
		JPanel leftR = new JPanel(new GridLayout(10, 2));
		leftR.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 10 , 10));
		
		String[] info= {"","","주택명","거래금액","월세금액","건축연도","전용면적","거래일","법정동","지번"};
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		homeInfoL = new JLabel[size];
		for (int i = 0; i <size; i++) {
			infoL[i] = new JLabel(info[i]);
			homeInfoL[i]=new JLabel("");
			leftR.add(infoL[i]);
			leftR.add(homeInfoL[i]);
		}
		imgL = new JLabel();
		leftCenter.add(imgL);
		leftCenter.add(leftR);
		
		left.add(new JLabel("아파트 거래 정보", JLabel.CENTER),"North");
		left.add(leftCenter,"Center");
		
		JPanel bottRight = new JPanel(new BorderLayout());
		JPanel bottRightCenter = new JPanel(new BorderLayout());

		envpModel = new DefaultTableModel(envpTitle, 20);
		envpTable = new JTable(envpModel);
		envpPane = new JScrollPane(envpTable);
		envpTable.setColumnSelectionAllowed(true);
		bottRightCenter.add(new JLabel("환경 오염 정보", JLabel.CENTER), "North");
		bottRightCenter.add(envpPane, "Center");

		bottRight.add(bottRightCenter, "Center");
		
		
		JPanel bottLeft = new JPanel(new BorderLayout());
		JPanel bottLeftCenter = new JPanel(new BorderLayout());
		
		convModel = new DefaultTableModel(convTitle, 20);
		convTable = new JTable(convModel);
		convPane = new JScrollPane(convTable);
		convTable.setColumnSelectionAllowed(true);
		bottLeftCenter.add(new JLabel("주변 상권", JLabel.CENTER), "North");
		bottLeftCenter.add(convPane, "Center");
		bottLeft.add(bottLeftCenter, "Center");
		
		
		
		/*오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightTop = new JPanel(new GridLayout(4, 2));
		JPanel rightTop1 = new JPanel(new GridLayout(1, 4));
		String[] chooseMeg= { "아파트 매매", "아파트 전월세", "주택 매매", "주택 전월세"};
		chooseC = new JCheckBox[chooseMeg.length];
		for (int i = 0, len= chooseMeg.length; i < len; i++) {
			chooseC[i] = new JCheckBox(chooseMeg[i], true);
			rightTop1.add(chooseC[i]);
		}
		
		
		JPanel rightTop2 = new JPanel(new GridLayout(1, 3));
		String[] item = {"---all---","동","아파트 이름"}; 
		findC = new JComboBox<String>(item);
		wordTf = new JTextField();
		searchBt = new JButton("검색");
		
		rightTop2.add(findC);
		rightTop2.add(wordTf);
		rightTop2.add(searchBt);
		
		rightTop.add(new Label(""));
		rightTop.add(rightTop1);
		rightTop.add(rightTop2);		
		rightTop.add(new Label(""));
		
		JPanel rightCenter = new JPanel(new BorderLayout());
		homeModel = new DefaultTableModel(title,20);
		homeTable = new JTable(homeModel);
		homePan = new JScrollPane(homeTable);
		homeTable.setColumnSelectionAllowed(true);
		rightCenter.add(new JLabel("거래 내역", JLabel.CENTER),"North");
		rightCenter.add(homePan,"Center");
		
		right.add(rightTop,"North");
		right.add(rightCenter,"Center");
		
		JPanel mainP = new JPanel(new GridLayout(2, 2));
		
		mainP.add(left);
		mainP.add(right);
		mainP.add(bottRight);
		mainP.add(bottLeft);
		
	
		
		mainP.setBorder(BorderFactory.createEmptyBorder(20 , 10 , 10 , 10));
		frame.add(mainP,"Center");
		
		/*이벤트 연결*/

		homeTable.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row =  homeTable.getSelectedRow();
				System.out.println("선택된 row : " + row);
				System.out.println("선택된 row의 column 값 :"+homeModel.getValueAt(row, 0));
				int code = Integer.parseInt(((String)homeModel.getValueAt(row, 0)).trim());
				showHomeInfo(code);
			}
		});
		
		// complete code #01
		// 아래의 코드를 참조하여 아래 라인을 uncomment 하고 searchBt.addActionList() 를 Lambda 표현식으로 바꾸세요.
		// searchBt.addActionListener( /* 여기 */ );
		
		 searchBt.addActionListener((e)->{
			 searchHomes();
		 } );
		 
	
		wordTf.addActionListener((e) -> {
			searchHomes();
			});
		 
//		 wordTf.addKeyListener(new KeyAdapter() {
//	    		@Override
//	    		public void keyReleased(KeyEvent e) {
//	    			if (e.getKeyCode()==10) {
//	    				 searchHomes();
//	    			}
//	    		}
//	    	});
		 
		 
		 
		 
////		 
//		showEnvp();
		showHomes();
	}
	
	
	/**검색 조건에 맞는 주택 정보 검색 */
	private void searchHomes() {
		for(int i = 0, size = chooseC.length; i<size; i++) {
			if(chooseC[i].isSelected()) {
				searchType[i] = true;
			}else {
				searchType[i] = false;
			}
		}
		word = wordTf.getText().trim();
		key = choice[findC.getSelectedIndex()];
		System.out.println("word:"+word+" key:"+key);
		showHomes();		
	}
	/**
	 * 주택 목록을  갱신하기 위한 메서드 
	 */
	public void showHomes(){
		HomePageBean  bean = new HomePageBean();
		bean.setSearchType(searchType);
		if(key !=null) {
			if(key.equals("dong")) {
				bean.setDong(word);
			}else if(key.equals("name")) {
				bean.setAptname(word);
			}
		}
		
		List<HomeDeal> deals = homeService.searchAll(bean);
		if(deals!=null){
			int i=0;
			String[][]data = new String[deals.size()][5];
			for (HomeDeal deal: deals) {
				data[i][0]= ""+deal.getNo();
				data[i][1]= deal.getDong();
				data[i][2]= deal.getAptName();
				data[i][3]= deal.getDealAmount();
				data[i++][4]= deal.getType();
			}
			homeModel.setDataVector(data, title);
		}
	}
	
	public void showEnvp() {
		List<EnvPollution> envps = envpService.search();
		
		if (envps != null) {
			int i = 0;
			String[][] data = new String[envps.size()][8];

			for (EnvPollution envp : envps) {
				System.out.println("이게모야"+envp);
				data[i][0] = envp.getTime();
				data[i][1] = ""+envp.getName();
				data[i][2] = envp.getCO();
				data[i][3] = ""+envp.getNO2();
				data[i][4] = envp.getO3();
				data[i][5] = ""+envp.getSO2();
				data[i][6] = envp.getFd();
				data[i++][7] = ""+envp.getUfd();

			}

			envpModel.setDataVector(data, envpTitle);
		} else {
			System.out.println("envps null");
		}
	}
	
	
	public void showEnvp(List<HomeDeal> deals) {
		int size=deals.size();
		String first=deals.get(0).getDong();
		String last=deals.get(size-1).getDong();
		
		if(first.charAt(0)==last.charAt(0)) {
			showEnvp(first);
		}else {
			showEnvp();
		}
	}
	public void showEnvp(String dong) {
		System.out.println("search: "+dong);
		List<EnvPollution> envps = envpService.search(dong);

		if (envps != null) {
			int i = 0;
			String[][] data = new String[envps.size()][8];

			for (EnvPollution envp : envps) {
				data[i][0] = envp.getTime();
				data[i][1] = envp.getName();
				data[i][2] = envp.getCO();
				data[i][3] = envp.getNO2();
				data[i][4] = envp.getO3();
				data[i][5] = envp.getSO2();
				data[i][6] = envp.getFd();
				data[i++][7] = envp.getUfd();

			}

			envpModel.setDataVector(data, envpTitle);
		} else {
			System.out.println("envps 가 널입니다.");
		}
	}
	
//	public static void main(String[] args) {
//		new HomeInfoView();
//	}
	
}

