import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ListHangHoaSieuThi {
    private NodeHangHoaSieuThi head, tail;
    HangHoaSieuThi hangHoa = new HangHoaSieuThi();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date ngayNhap = new Date();
    Scanner sc = new Scanner(System.in);
    public ListHangHoaSieuThi()
    {
        hangHoa.autoId = 1;
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty()
    {
        return this.head == null;
    }
    public void ThemHangHoa(HangHoaSieuThi hangHoa)
    {
        if(isEmpty())
        {
            this.head = this.tail = new NodeHangHoaSieuThi(hangHoa);
            return;
        }
        NodeHangHoaSieuThi newNode = new NodeHangHoaSieuThi(hangHoa);
        this.tail.setNext(newNode);
        this.tail = newNode;

    }
    public void HienThiHangHoa()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~THONG TIN HANG HOA~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        NodeHangHoaSieuThi node = this.head;
        while(node != null){
            System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
            node = node.getNext();
        }
    }
    public void ThemNhieuHangHoa(HangHoaSieuThi...hangHoas)
    {
        for(HangHoaSieuThi hangHoa : hangHoas)
        {
            ThemHangHoa(hangHoa);
        }
    }
    public boolean XoaHangHoa(int id)
    {
        NodeHangHoaSieuThi node = this.head;
        if(this.head.getHangHoa().getiD() == id){
            this.head = this.head.getNext();
            System.out.println("Da Xoa Doi Tuong Dau Tien!!");
            return true;
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getiD() == id){
                node.setNext(node.getNext().getNext());
                System.out.println("Xoa Thanh Cong!!!");
                return true;
            }
            else{
                System.out.println("ID Khong Ton Tai!!");
            }
            node = node.getNext();
        }
        System.out.println("Xoa Khong Thanh Cong!");
        return false;
    }
    public boolean SuaThongTin(int id){
        NodeHangHoaSieuThi node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getiD() == id)
            {
                String loaiHh = null;
                System.out.println("Nhap Ten Hang:");
                String ten = sc.nextLine();
                System.out.println("Nhap So Luong:");
                int soLuong = sc.nextInt();
                System.out.println("Nhap Gia:");
                float gia = sc.nextFloat();
                System.out.println("Nhap Loai Hang [1: Thuc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("Loai Khong Hop Le!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhap Ngay Vao Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngay Khong Hop Le!!!!");
                }
                node.getHangHoa().setTenHangHoa(ten);
                node.getHangHoa().setSoLuong(soLuong);
                node.getHangHoa().setGiaHang(gia);
                node.getHangHoa().setLoai(loaiHh);
                node.getHangHoa().setNgayNhap(ngayNhap);
                return true;
            }
            node = node.getNext();
        }
        System.out.println("Khong The Fix!!!");
        return false;
    }
    public void SapXepTangDan(){
        NodeHangHoaSieuThi node = this.head, node2 = null;
        HangHoaSieuThi tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang < node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }

    public void SapXepGiamDan(){
        NodeHangHoaSieuThi node = this.head, node2 = null;
        HangHoaSieuThi tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang > node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }
    public boolean TimKiemTheoLoai(String l){
        System.out.println("--------------------THONG TIN HANG HOA--------------------");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        NodeHangHoaSieuThi node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getLoai().contains(l))
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Search Khong Hop Le!");
            return false;
        }
        return true;
    }
    public boolean TimKiemTheoGia(float gF, float gT){
        System.out.println("--------------------THONG TIN HANG HOA--------------------");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "ma hang", "ten hang", "so luong", "gia hang", "loai hang", "ngay nhap kho");
        boolean isFound = false;
        NodeHangHoaSieuThi node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getGiaHang() >= gF && node.getHangHoa().getGiaHang() <= gT)
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Gia Muon Tim Khong Hop Le!");
            return false;
        }
        return true;
    }
    public void ThongKe(){
        NodeHangHoaSieuThi node = this.head;
        int sLtemp = 0;
        float gTtemp = 0;
        while(node != null){
            sLtemp += node.getHangHoa().getSoLuong();
            gTtemp += node.getHangHoa().getGiaHang();
            node = node.getNext();
        }
        System.out.println("--------------------BANG THONG KE--------------------");
        System.out.printf("%-30S %-30S\n", "Tong SL", "Tong GT");
        System.out.printf("%-30d %-12.3fVND\n", sLtemp, gTtemp);
    }
    public void DuLieuMacDinh(){
        try {
            String sDate1 = "25/12/2021";  
            String sDate2 = "18/12/2021";  
            String sDate3 = "13/12/2021";  
            String sDate4 = "07/12/2021";  
            String sDate5 = "22/12/2021";  
            String sDate6 = "02/12/2021";  
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
            Date date1=formatter1.parse(sDate1);  
            Date date2=formatter1.parse(sDate2);  
            Date date3=formatter1.parse(sDate3);  
            Date date4=formatter1.parse(sDate4);  
            Date date5=formatter1.parse(sDate5);  
            Date date6=formatter1.parse(sDate6); 
            HangHoaSieuThi HangHoaSieuThi1 = new HangHoaSieuThi(250, "Chuoi gia", "Thuc Pham", 50, date2);
            HangHoaSieuThi HangHoaSieuThi2 = new HangHoaSieuThi(1250, "Dua luoi", "Thuc Pham", 250, date3);
            HangHoaSieuThi HangHoaSieuThi3 = new HangHoaSieuThi(10000, "Chen su", "Sanh Su", 600, date5);
            HangHoaSieuThi HangHoaSieuThi4 = new HangHoaSieuThi(15000, "To su", "Sanh Su", 100, date4);
            HangHoaSieuThi HangHoaSieuThi5 = new HangHoaSieuThi(50000, "May giat", "Dien May", 2, date1);
            HangHoaSieuThi HangHoaSieuThi6 = new HangHoaSieuThi(500, "Thach dua", "Thuc Pham", 100, date4);
            HangHoaSieuThi HangHoaSieuThi7 = new HangHoaSieuThi(750, "Muong nhua", "Sanh su", 10, date2);
            HangHoaSieuThi HangHoaSieuThi8 = new HangHoaSieuThi(800, "Chuoi non", "Thuc Pham", 650, date5);
            HangHoaSieuThi HangHoaSieuThi9 = new HangHoaSieuThi(1900, "Laptop", "Dien May", 1300, date4);
            HangHoaSieuThi HangHoaSieuThi10 = new HangHoaSieuThi(2500, "Xoai", "Thuc Pham", 800, date2);
            HangHoaSieuThi HangHoaSieuThi11 = new HangHoaSieuThi(4500, "May tinh", "Dien May", 50, date4);
            HangHoaSieuThi HangHoaSieuThi12 = new HangHoaSieuThi(8500, "Xuc xich", "Thuc Pham", 100, date2);
            HangHoaSieuThi HangHoaSieuThi13 = new HangHoaSieuThi(5000, "Ly su", "Sanh Su", 20, date5);
            HangHoaSieuThi HangHoaSieuThi14 = new HangHoaSieuThi(6000, "Thit nguoi", "Thuc Pham", 40, date1);
            HangHoaSieuThi HangHoaSieuThi15 = new HangHoaSieuThi(30, "May nuoc nong", "Dien May", 8500, date3);
            HangHoaSieuThi HangHoaSieuThi16 = new HangHoaSieuThi(4500, "Noi com", "Dien May", 82, date2);
            HangHoaSieuThi HangHoaSieuThi17 = new HangHoaSieuThi(250, "Sushi", "Thuc Pham", 678, date3);
            HangHoaSieuThi HangHoaSieuThi18 = new HangHoaSieuThi(60, "Dua hau", "Thuc Pham", 84, date4);
            HangHoaSieuThi HangHoaSieuThi19 = new HangHoaSieuThi(850, "Tao do", "Thuc Pham", 450, date5);
            HangHoaSieuThi HangHoaSieuThi20 = new HangHoaSieuThi(50, "Gan bo", "Thuc Pham", 600, date2);
            ThemHangHoa(HangHoaSieuThi1);
            ThemHangHoa(HangHoaSieuThi2);
            ThemHangHoa(HangHoaSieuThi3);
            ThemHangHoa(HangHoaSieuThi4);
            ThemHangHoa(HangHoaSieuThi5);
            ThemHangHoa(HangHoaSieuThi6);
            ThemHangHoa(HangHoaSieuThi7);
            ThemHangHoa(HangHoaSieuThi8);
            ThemHangHoa(HangHoaSieuThi9);
            ThemHangHoa(HangHoaSieuThi10);
            ThemHangHoa(HangHoaSieuThi11);
            ThemHangHoa(HangHoaSieuThi12);
            ThemHangHoa(HangHoaSieuThi13);
            ThemHangHoa(HangHoaSieuThi14);
            ThemHangHoa(HangHoaSieuThi15);
            ThemHangHoa(HangHoaSieuThi16);
            ThemHangHoa(HangHoaSieuThi17);
            ThemHangHoa(HangHoaSieuThi18);
            ThemHangHoa(HangHoaSieuThi19);
            ThemHangHoa(HangHoaSieuThi20);
        } catch (Exception e) {
            e.getCause();
        }
    }
}