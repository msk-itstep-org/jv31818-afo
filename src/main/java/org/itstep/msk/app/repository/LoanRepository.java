package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Device;
import org.itstep.msk.app.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    //???поиск множества устройств по владельцу устройства
//    Iterable<Device> findAllByOwner(String owner);

    //поиск множества устройств по артикулу (deviceSKU)
//    Iterable<Device> findByDeviceSKU(String deviceSKU);

    //поиск 1 устройства по серийному номеру
//    Optional<Device> findByDeviceSN(String deviceSN);

    //???поиск множества устройств по описанию устройств
//    Iterable<Device> findByDeviceDesc(String deviceDesc);

    //???поиск множества устройств по описанию аренды
//    Iterable<Loan> findByLoanDesc (String loanDesc);

    //???поиск всех арендованных и НЕарендованных устройств
//    Iterable<Loan> findByLoaned (Integer loaned);


}
