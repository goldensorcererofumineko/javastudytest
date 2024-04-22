package dao;

import dto.CategoryDto;
import dto.QuestionDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.DbConn.getConn;

public class CategoryDao {

    public List<CategoryDto> getCategoryList() {

        Connection conn = getConn();

        try {
            String sql = "SELECT * FROM category";
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(sql);

            // 変換 ResultSet -> List<UserInfodto>
            List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();

            while(rs.next()) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(rs.getInt("id"));
                categoryDto.setTitle(rs.getString("title"));

                categoryDtoList.add(categoryDto);
            }

            return categoryDtoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
