package com.jaywant.demo.Repo;

import com.jaywant.demo.Entity.Attendance;
import com.jaywant.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployee(Employee employee);

    // Optional<Attendance> findByEmployeeIdAndEmployeeNameAndCompanyNameAndDate(
    // Long employeeId, String employeeName, String companyName, LocalDate date);

    Optional<Attendance> findByEmployeeAndDate(Employee employee, String date);

    @Query("SELECT a FROM Attendance a WHERE CONCAT(a.employee.firstName, ' ', a.employee.lastName) = :fullName AND a.date = :date")
    List<Attendance> findByEmployeeFullNameAndDate(@Param("fullName") String fullName, @Param("date") String date);

    List<Attendance> findByDate(String date);


}
