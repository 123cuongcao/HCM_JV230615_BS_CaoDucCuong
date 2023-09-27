package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice ;
        int indexBook = 0;
        Book[] arrBook = new Book[100];


        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                    "2. Hiển thị thông tin tất cả sách trong thư viện \n" +
                    "3. Sắp xếp sách theo lợi nhuận tăng dần \n" +
                    "4. Xóa sách theo mã sách\n" +
                    "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả\n" +
                    "6. Thay đổi thông tin sách theo mã sách \n" +
                    "7. Thoát ");
            System.out.println("hãy nhập lựa chọn của bạn");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    System.out.println("Hãy nhập số lượng sách bạn muốn thêm ");
                    int n = Integer.parseInt(sc.nextLine());
                    for(int i = 0; i<n; i++){
                        arrBook[indexBook]= new Book();
                        System.out.println("Điền thông tin sách thứ"+(i+1));
                        arrBook[indexBook].inputData(sc,arrBook,indexBook);
                        indexBook ++;
                    }
                    break;
                case 2:
                    for(int i=0; i<indexBook; i++){
                        System.out.println(arrBook[i].toString());
                    }
                    break;
                case 3:
                    for (int i = 0; i < indexBook - 1; i++) {
                        for (int j = i + 1; j < indexBook; j++) {
                            if (arrBook[i].getInterest() > arrBook[j].getInterest()) {
                                Book temp = arrBook[i];
                                arrBook[i] = arrBook[j];
                                arrBook[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã được sắp xếp theo thứ tự tăng dần của lợi nhuận");
                    break;
                case 4:
                    System.out.println("Hãy nhập mã sách muốn xóa");
                    int wantDelete = Integer.parseInt(sc.nextLine());
                    int checkDelete = -1;
                    for (int i = 0; i < indexBook; i++) {
                        if (arrBook[i].getBookId() == wantDelete) {
                            checkDelete = i;
                            break;
                        }
                    }
                    if (checkDelete != -1) {
                        for (int i = checkDelete; i < indexBook - 1; i++) {
                            arrBook[i] = arrBook[i + 1];
                        }
                        arrBook[indexBook - 1] = null;
                        indexBook--;
                    } else {
                        System.out.println("Không tìm thấy sách để xóa");
                    }
                    break;
                case 5:
                    System.out.println("Hãy chuỗi tìm kiếm từ bàn phím");
                    String wantFind = sc.nextLine();
                    int checkWantFind = -1;
                    for(int i=0;i<indexBook;i++ ){
                        if(arrBook[i].getBookName().contains(wantFind) || arrBook[i].getDescriptions().contains(wantFind)){
                            System.out.println(arrBook[i].toString());
                            checkWantFind = 1;
                        }
                    }
                    if(checkWantFind == -1){
                        System.out.println("Không tìm thấy tên sách hay mô tả sách nào");
                    }
                    break;

                case 6:
                    System.out.println("Hãy nhập vào mã sản phẩm bạn muốn thay đổi ");
                    int wantChangeId  =  Integer.parseInt(sc.nextLine());
                    int findIdCheck = -1;
                    for(int i=0; i<indexBook;i++){
                        if(arrBook[i].getBookId()==wantChangeId){
                            arrBook[i].inputData(sc,arrBook,indexBook);
                            System.out.println("Trang thái sách");
                            boolean wantStatus = Boolean.getBoolean(sc.nextLine());
                            arrBook[i].setBookStatus(wantStatus);
                            findIdCheck = 1;
                            break;
                        }
                    }
                    if(findIdCheck == -1){
                        System.out.println("Ko tìm thấy sách nào phù hôp với id bạn vừa nhập");
                    }
                    break;
                case 7:
                    sc.close();
                    System.exit(0);


            }
        }while(choice!=7);
    }
}
