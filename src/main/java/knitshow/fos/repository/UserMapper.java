package knitshow.fos.repository;

import knitshow.fos.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserEntity findUserByOAuth2Id(String id);
    public UserEntity findUserByEmail(String email);
    public int insertUser(UserEntity user);
}
