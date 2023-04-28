public class Users1 {
    String name;String club;String branch;int prn;String requirments;
    String 	reason;
    String 	date;String responsible_person;
    Users1()
    {
        name=club=branch=requirments=reason=date=responsible_person="";
        prn=0;
    }
    Users1(String name, String club,String branch,int prn,String requirments,String reason,String date,String responsible_person)
    {
        this.name=name;
        this.club=club;
        this.branch=branch;
        this.prn=prn;
        this.requirments=requirments;
        this.reason=reason;
        this.date=date;
        this.responsible_person=responsible_person;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getClub()
    {
        return this.club;
    }

    public void setClub(String name)
    {
        this.club=name;
    }
    public String getBranch()
    {
        return this.branch;
    }
    public void setBranch(String a)
    {
        this.branch=a;
    }
    public int getPrn()
    {
        return this.prn;
    }
    public void setPrn(int b)
    {
        this.prn=b;
    }

    public String getReq()
    {
        return this.requirments;
    }
    public void setReq(String a)
    {
        this.requirments=a;
    }
    public String getReason()
    {
        return this.reason;
    }
    public void setReason(String b)
    {
        this.reason=b;
    }
    public String getDate()
    {
        return this.date;
    }
    public void setDate(String a)
    {
        this.date=a;
    }  
}