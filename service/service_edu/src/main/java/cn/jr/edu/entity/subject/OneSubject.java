package cn.jr.edu.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
/**
 * @author JR
 */
@Data
public class OneSubject {

    private String id;

    private String title;

    private List<TwoSubject> children=new ArrayList<>();

}
