package org.itstep.msk.app.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "devices")
//Inheritance дискриминатор MappedSuperclass
public class Device {

    @Column(name = "id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //устройство обязано принадлежать только одному из User
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    //таблица аренды устройств, где есть 2 ключа - user_id и device_id
    @OneToMany(targetEntity = Loan.class, mappedBy = "device")
    private Set<Loan> loans;

    //поле описание устройства, которое должно быть обязательно заполнено
    @Column(name = "device_desc", nullable = false)
    @NotBlank
    private String deviceDesc;

    //артикул устройства, не обязателен, но очень желателен
    @Column(name = "device_sku", unique = true)
    private String deviceSKU;

    //серийный номер устройства, не обязателен, но очень желателен
    @Column(name = "device_sn", unique = true)
    private String deviceSN;

    //флаг, будет ли отображаться в списке устройств
    @Column(name = "archived_devices")
    private Integer archivedDevice;

    //@Column(name = "device_location")
    //private String deviceLocation;

    public Integer getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    public String getDeviceSKU() {
        return deviceSKU;
    }

    public void setDeviceSKU(String deviceSKU) {
        this.deviceSKU = deviceSKU;
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }

    public Integer getArchivedDevice() {
        return archivedDevice;
    }

    public void setArchivedDevice(Integer archivedDevice) {
        this.archivedDevice = archivedDevice;
    }

}
