public class NodeHangHoaSieuThi {
    public HangHoaSieuThi hangHoa;
    public NodeHangHoaSieuThi next;
    public NodeHangHoaSieuThi()
    {

    }
    public NodeHangHoaSieuThi(HangHoaSieuThi hangHoa)
    {
        this.hangHoa = hangHoa;
        this.next = null;
    }
    public HangHoaSieuThi getHangHoa() {
        return hangHoa;
    }
    public void setHangHoa(HangHoaSieuThi hangHoa) {
        this.hangHoa = hangHoa;
    }
    public NodeHangHoaSieuThi getNext() {
        return next;
    }
    public void setNext(NodeHangHoaSieuThi next) {
        this.next = next;
    }
    public NodeHangHoaSieuThi(HangHoaSieuThi hangHoa, NodeHangHoaSieuThi next) {
        this.hangHoa = hangHoa;
        this.next = next;
    }
}
