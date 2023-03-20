package net.kumasi.ushop.domain.shopper;

import org.springframework.beans.BeanUtils;

import java.util.List;

public class PersonMapper {


    public static void mapToModel(List<Person> modelList,
                           List<PersonEntity> domainList) throws Exception {
        for (PersonEntity domain : domainList) {
            Person model = new Person();
            PersonMapper.mapToModel(model, domain);
            modelList.add(model);
        }
    }
    public static void mapToModel(
            Person destination,
            PersonEntity source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }
    public  static void mapToDomain(
            PersonEntity domain,
            Person model
    ) throws Exception {
        BeanUtils.copyProperties(model, domain);
        System.out.println(domain);;
    }
    public static void mapToDomain(List<PersonEntity> domainList,
                            List<Person> modelList) throws Exception {
        for (Person model : modelList) {
            PersonEntity domain = new PersonEntity();
            PersonMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}
