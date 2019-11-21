package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Device.class)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;

    // описание аренды
    @Column(name = "loan_desc", nullable = false)
    @NotBlank
    private String loanDesc;

    // дата начала аренды устройства
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "days_quantity")
    private Integer daysQuantity; // количество дней аренды, вычисляется приложением

    // флаг, обозначающий, занято ли устройство или доступно для аренды
    @Column(name = "loaned")
    private Integer loaned;
    // public Boolean getLoaned() { return loaned > 0; }
    // public void setLoaned(Boolean loaned) { this.loaned = loaned ? 1 : 0; }


    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getLoanDesc() {
        return loanDesc;
    }

    public void setLoanDesc(String loanDesc) {
        this.loanDesc = loanDesc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDaysQuantity() {
        return daysQuantity;
    }

    public void setDaysQuantity(Integer daysQuantity) {
        this.daysQuantity = daysQuantity;
    }

    public Integer getLoaned() {
        return loaned;
    }

    public void setLoaned(Integer loaned) {
        this.loaned = loaned;
    }
}
