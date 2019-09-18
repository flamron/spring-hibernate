package by.pvt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee", schema = "employee-storage")
public class Employee extends BaseEntity<Long> {

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
