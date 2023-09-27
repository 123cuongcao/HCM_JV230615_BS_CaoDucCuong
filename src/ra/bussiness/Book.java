package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;
    private static int count = 0;

    public Book() {
        this.bookStatus = true;
        idGenerate();
    }

    private void idGenerate(){
        this.bookId = count;
        count++;
    }
    public void inputData(Scanner sc, Book[] arrBook , int indexBook){
        boolean bookNameCheck = false;
        while(!bookNameCheck){
            System.out.println("Hãy nhập vào tên sách (Không được để trống)");
            String bookNameTest = sc.nextLine();
            if(bookNameTest.isEmpty()){
                System.out.println("tên sách (Không được để trống)");
            }else {
                this.bookName = bookNameTest;
                bookNameCheck = true;
            }
        }


        boolean authorCheck = false;
        while(!authorCheck){
            System.out.println("Hãy nhập vào tên tác giả (Không được để trống)");
            String authorTest = sc.nextLine();
            if(authorTest.isEmpty()){
                System.out.println("tên tác giả (Không được để trống)");
            }else {
                this.author = authorTest;
                authorCheck = true;
            }
        }

        boolean descriptionsCheck = false ;
        while(!descriptionsCheck){
            System.out.println("Nhập mô tả sách (Không được để trống, ít nhất 10 ký tự)");
            String descriptionsTest = sc.nextLine();
            if(descriptionsTest.isEmpty()){
                System.out.println("(Không được để trống");
            }else {
                if(descriptionsTest.length()>=10){
                    this.descriptions = descriptionsTest;
                    descriptionsCheck = true;
                }else {
                    System.out.println("Mô tả của sách phải ít nhất 10 ký tự");
                }
            }
        }

        boolean importPriceCheck = false;
        while(!importPriceCheck){
            System.out.println("Hãy điền vào giá nhập");
            double importPriceTest = Double.parseDouble(sc.nextLine());
            if(importPriceTest<0){
                System.out.println("Giá nhập phải lớn hơn 0");
            }else {
                this.importPrice = importPriceTest;
                importPriceCheck = true;
            }
        }

        boolean exportPriceCheck = false;
        while(!exportPriceCheck){
            System.out.println("Giá xuất (phải lớn hơn 1.2 lần giá nhập)");
            double exportPriceTest = Double.parseDouble(sc.nextLine());
            if(exportPriceTest*1.2>=getImportPrice()){
                this.exportPrice = exportPriceTest;
                exportPriceCheck = true;
            }else {
                System.out.println("Giá xuất phải lớn hơn 1.2 lần giá nhập");
            }
        }



    }

//    public float interestNha(){
//       float interestTest = (float) exportPrice- (float)importPrice;
//       return this.interest = interestTest;
//    }



    public String displayData(){
        return this.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", bookStatus=" + (bookStatus?"Có sách":"Hết sách") +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        float interestTest = (float) exportPrice- (float)importPrice;
        return this.interest = interestTest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
