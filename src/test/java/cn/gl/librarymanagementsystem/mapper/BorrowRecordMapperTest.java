package cn.gl.librarymanagementsystem.mapper;

import cn.gl.librarymanagementsystem.dto.BorrowRecordDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BorrowRecordMapperTest {
    @Autowired
    BorrowRecordMapper mapper;

    @Test
    public void test1(){
        List<BorrowRecordDTO> allBorrowRecord = mapper.getAllBorrowRecord();
        System.out.println(allBorrowRecord);
    }
}