package test;
import java.net.*;
import java.util.Arrays;
import java.util.HashMap;
import java.io.*;

public class SEOUL19_AHNRYEOHWAN_KONGJINHO {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "SEOUL19_KONGJINHO";

    // 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
    static final String HOST = "127.0.0.1";

    // 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경에 대한 상수입니다.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
//    static final int[][] HOLES = { { 1, 1 }, { 126, 1 }, { 253, 1 }, { 1, 126 }, { 126, 126 }, { 253, 126 } };
    static final int HOLE_SIZE = 6;
    static final double diam = 5.37;
    static boolean[] PossibleHole = new boolean[HOLE_SIZE];
    static HashMap<Integer, String> hole_display = new HashMap<>();

    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }
        
        

    }

    static double getDistance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static double getRealAngle(double ang) {
        return (450 - ang) % 360;
    }

    static double getAngle(Point p1,Point p2) {
        double dx = p2.x-p1.x;
        double dy = p2.y-p1.y;
        double ans =Math.atan2(dy,dx);
        double rad = (180.0 / Math.PI) * ans;
        
        return rad;
        
    }

    static void findHole(double gred, Point white, double x1, double y1) {
        PossibleHole = new boolean[HOLE_SIZE];

        double checkY =  gred * (white.x - x1) + y1;
        boolean isBelow = true;
        
        if(checkY > white.y) {
            isBelow = false;
        }
        

        for (int i = 0; i < HOLE_SIZE; i++) {
            double newY = gred * (HOLES[i][0] - x1) + y1;
            if(isBelow) {
                if (HOLES[i][1] < newY) {
                    PossibleHole[i] = true;
                }
            }
            else {
                if (HOLES[i][1] > newY) {
                    PossibleHole[i] = true;
                }
            }
            

        }

    }
    
    static Point newTarget(Point target) {
        for (int i = 0; i < HOLE_SIZE; i++) {
            if (PossibleHole[i]) {
                Point targetHole = new Point(HOLES[i][0], HOLES[i][1]);
                double theta = getAngle(target, targetHole);
                System.out.println("각도는 : "+    theta);
                double tx;
                double ty;
                tx =  target.x+diam*Math.abs(Math.cos(theta));
                ty = target.y-diam*Math.abs(Math.sin(theta));
                
                if (theta>0) {
                    tx =  target.x+diam*Math.abs(Math.cos(theta));
                    ty = target.y-diam*Math.abs(Math.sin(theta));
                }
                else if(theta>90) {
                    tx =  target.x-diam*Math.abs(Math.cos(theta));
                    ty = target.y+diam*Math.abs(Math.sin(theta));
                    
                }
                else if(theta<0) {
                    tx =  target.x+diam*Math.abs(Math.cos(theta));
                    ty = target.y-diam*Math.abs(Math.sin(theta));
                    
                }
                else if(theta<-90) {
                    tx =  target.x-diam*Math.abs(Math.cos(theta));
                    ty = target.y-diam*Math.abs(Math.sin(theta));
                    
                }
//                else {
//                    tx = target.x-diam*Math.cos(theta);
//                    ty = target.y+diam*Math.sin(theta);
//                }
                Point newT = new Point(tx,ty);
                System.out.println(target);
                System.out.println(newT);
                System.out.println(hole_display.get(i)+" "+HOLES[i][0]+" "+HOLES[i][1]);
                if(0<= newT.x && newT.x<254 && 0<=newT.y&& newT.y<127) {
                    return new Point(newT.x,newT.y);
                }
            }
        }
        
        return null;
    }

    public static void main(String[] args) {

        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;
        hole_display.put(0, "아래 왼쪽");
        hole_display.put(1, "아래 가운데 ");
        hole_display.put(2, "아래 오른쪽");
        hole_display.put(3, "위 왼쪽");
        hole_display.put(4, "위 가운데");
        hole_display.put(5, "위 오른쪽");

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int) balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                double angle = 0.0f;
                float power = 0.0f;

                //////////////////////////////
                // 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
                //
                // 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
                // - order: 1인 경우 선공, 2인 경우 후공을 의미
                // - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
                // 예) balls[0][0]: 흰 공의 X좌표
                // balls[0][1]: 흰 공의 Y좌표
                // balls[1][0]: 1번 공의 X좌표
                // balls[4][0]: 4번 공의 X좌표
                // balls[5][0]: 마지막 번호(8번) 공의 X좌표

                // 여기서부터 코드를 작성하세요.
                // 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.



                int[] FIRST = { 1, 3, 5 };
                int[] SECOND = { 2, 4, 5 };
                // target.x, target.y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수

                Point white = new Point(balls[0][0], balls[0][1]);
                Point target = new Point(balls[1][0], balls[1][1]);
                
                
                if (order==1) {
                    for (int i = 0; i < 3; i++) {
                        if (balls[FIRST[i]][0] < 0 || balls[FIRST[i]][1] < 0)
                            continue;
                        target.x = balls[FIRST[i]][0];
                        target.y = balls[FIRST[i]][1];
                        break;
                    }
                }
                else {
                    for (int i = 0; i < 3; i++) {
                        if (balls[SECOND[i]][0] < 0 || balls[SECOND[i]][1] < 0)
                            continue;
                        target.x = balls[SECOND[i]][0];
                        target.y = balls[SECOND[i]][1];
                        break;
                    }
                    
                }


                double gred = (target.y - white.y) / (target.x - white.x);
                double reverse = (-1.0) / gred;
                findHole(reverse, white,target.x, target.y);
                
                
                Point newT = newTarget(target);
                if(newT == null) {
                    newT = new Point(target.x,target.y);
                }
                
                


                // width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
                double width = Math.abs(newT.x - white.x);
                double height = Math.abs(newT.y - white.y);
                
                

                // radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
                // - 1radian = 180 / PI (도)
                // - 1도 = PI / 180 (radian)
                // angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
//                double radian = height > 0 ? Math.atan(width / height) : 0;
//                angle = (float) ((180.0 / Math.PI) * radian);

                // 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
                double finalAngle = getAngle(white,newT);
                angle= getRealAngle(finalAngle);
                
                
                
                
                

                // distance: 두 점(좌표) 사이의 거리를 계산
                double distance = Math.sqrt((width * width) + (height * height));

                // power: 거리 distance에 따른 힘의 세기를 계산
                power = (float) (distance*0.7);
//                power = (float) (100*0.7);

                // 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
                // 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
                // - angle: 흰 공을 때려서 보낼 방향(각도)
                // - power: 흰 공을 때릴 힘의 세기
                //
                // 이 때 주의할 점은 power는 100을 초과할 수 없으며,
                // power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
                //
                // 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
                //////////////////////////////

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}