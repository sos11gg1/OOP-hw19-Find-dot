package com.example.lib;

import java.util.Scanner;

public class Cube {
    private Scanner scanner = new Scanner(System.in);
    private float cube[] = new float[40];
    private float point[] = new float[20];
    private int cubeN=0,cubeC=0,pointN=0,pointC=0;


    public void makemoreCube(){
        System.out.println("�п�J r �إ߯x��(�̦h�إ�10��)�A�ο�J e ����");
        String s =scanner.next();
        while ((s.matches("r")!=true)&&(s.matches("e")!=true)){
            System.out.println("�п�J r �إ߯x��(�̦h�إ�10��)�A�ο�J e ����");
            s =scanner.next();
        }
        if(s.matches("r")){
            cubeN++;
            makeCube(cubeN,cubeC);
            cubeC+=4;
            makemoreCube();
        }
        else if(s.matches("e")){
            System.out.println("����");
        }
    }

    public void makemorePoint(){
        System.out.println("�п�J p �إ��I(�̦h�إ�10��)�A�ο�J e ����");
        String s =scanner.next();
        while ((s.matches("p")!=true)&&(s.matches("e")!=true)){
            System.out.println("�п�J p �إ��I(�̦h�إ�10��)�A�ο�J e ����");
            s =scanner.next();
        }
        if(s.matches("p")){
            pointN++;
            makePoint(pointN,pointC);
            pointC+=2;
            makemorePoint();
        }
        else if(s.matches("e")){
            System.out.println("����");
        }
    }

    private void setLowRight(int cC,float LRx,float LRy){
        cube[cC]=LRx;
        cube[cC+1]=LRy;
    }
    private void setUpLeft(int cC,float ULx,float ULy){
        cube[cC+2]=ULx;
        cube[cC+3]=ULy;
    }

    public  void makeCube(int cN,int cC){
        while ((cube[cC]<=cube[cC+2])||(cube[cC+1]>=cube[cC+3])){
            System.out.printf("�п�J�x�� %d �����T���W(�榡:x y)\n",cN);
            setUpLeft(cC,scanner.nextFloat(),scanner.nextFloat());
            System.out.printf("�п�J�x�� %d �����T�k�U(�榡:x y)\n",cN);
            setLowRight(cC,scanner.nextFloat(),scanner.nextFloat());
        }
    }
    public void makePoint(int pN,int pC){
        System.out.printf("�п�J�I %d (�榡:x y)\n",pN);
        point[pC]=scanner.nextFloat();
        point[pC+1]=scanner.nextFloat();
    }

    public void pointCheck(){
        for (int j=0;j<pointN;j++){
            for(int i=0;i<cubeN;i++){
                if ((point[(j*2)]<cube[(i*4)])&&(point[((j*2)+1)]>cube[((i*4)+1)])&&(point[((j*2))]>cube[((i*4)+2)])&&(point[((j*2)+1)]<cube[((i*4)+3)])){
                    System.out.printf("�I%d�b��%d��\n",(j+1),(i+1));
                }
                else{
                    System.out.printf("�I%d���b��%d��\n",(j+1),(i+1));
                }
            }
        }
    }
}
