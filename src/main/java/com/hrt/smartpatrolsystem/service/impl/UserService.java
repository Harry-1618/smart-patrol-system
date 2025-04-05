package com.hrt.smartpatrolsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.smartpatrolsystem.common.vos.PageResponseResult;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.mapper.UserMapper;
import com.hrt.smartpatrolsystem.service.IUserService;
import com.hrt.smartpatrolsystem.user.dtos.UserDTO;
import com.hrt.smartpatrolsystem.user.dtos.UserPWDChangeDTO;
import com.hrt.smartpatrolsystem.user.dtos.UserPageDTO;
import com.hrt.smartpatrolsystem.user.pojos.User;
import com.hrt.smartpatrolsystem.user.vos.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: UserService
 * Package: com.hrt.smartpatrolsystem.service.impl
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/29 - 18:04
 * @Version: v1.0
 */
@Service
@Transactional
@Slf4j
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    /**
     * 根据id查询用户
     * @param id
     */
    @Override
    public ResponseResult<UserVO> getUserById(Integer id) {
        User user = getById(id);
        if (user == null || user.getIsDeleted() == 1){
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO,UserVO.class);
        return ResponseResult.okResult(userVO);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public ResponseResult deleteUserById(Integer id) {
        boolean update = update(Wrappers.<User>lambdaUpdate().eq(User::getId, id).set(User::getIsDeleted, 1));
        if (update){
            return ResponseResult.okResult(null);
        }
        return ResponseResult.errorResult(HttpCodeEnum.ERROR);
    }

    /**
     * 添加用户
     * @param userDTO
     */
    @Override
    public ResponseResult addUser(UserDTO userDTO) {
        if(userDTO==null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        User user = new User();
        BeanUtils.copyProperties(userDTO,user,User.class);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        save(user);
        return ResponseResult.okResult(null);
    }

    /**
     * 修改用户
     * @param id
     * @param userDTO
     */
    @Override
    public ResponseResult updateUser(Integer id, UserDTO userDTO) {
        if (userDTO == null) {
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        }

        // 查询数据库中原有的用户信息
        User oldUser = getById(id);
        if (oldUser == null) {
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        }

        if (oldUser.getIsDeleted()==1)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);

        // 拷贝非空字段
        BeanUtils.copyProperties(userDTO, oldUser, getNullPropertyNames(userDTO));

        // 设置更新时间
        oldUser.setUpdatedTime(new Date());

        // 执行更新
        boolean update = updateById(oldUser);
        if (!update) {
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        }
        return ResponseResult.okResult(null);
    }

    /**
     * 分页查询用户列表
     * @param userPageDTO
     * @return
     */
    @Override
    public ResponseResult getUserList(UserPageDTO userPageDTO) {
        if (userPageDTO == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        userPageDTO.checkParam();
        IPage<User> page=new Page(userPageDTO.getPage(),userPageDTO.getPageSize());
        // 构建查询条件，注意使用 User 实体类的字段
        page = page(page, Wrappers.<User>lambdaQuery()
                .like(userPageDTO.getUsername() != null, User::getUsername, userPageDTO.getUsername())
                .like(userPageDTO.getName() != null, User::getName, userPageDTO.getName())
                .eq(userPageDTO.getRole() != null, User::getRole, userPageDTO.getRole())
                .eq(userPageDTO.getPhone() != null, User::getPhone, userPageDTO.getPhone())
                .eq(userPageDTO.getEmail() != null, User::getEmail, userPageDTO.getEmail())
                .eq(userPageDTO.getStatus() != null, User::getStatus, userPageDTO.getStatus())
        );

        // 将查询结果转换为 UserVO 列表
        List<UserVO> userVOList = page.getRecords().stream()
                .map(this::convertToUserVO)
                .toList();

        // 构建返回结果
        ResponseResult responseResult=new PageResponseResult(userVOList.size());
        responseResult.setData(userVOList);
        responseResult.setMsg(HttpCodeEnum.SUCCESS.getMsg());
        responseResult.setCode(HttpCodeEnum.SUCCESS.getCode());
        return responseResult;
    }

    /**
     * 修改用户密码
     * @param id
     * @param userDTO
     */
    @Override
    public ResponseResult updateUserPWD(Integer id, UserPWDChangeDTO userDTO) {
        if (userDTO == null|| id == null)
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        UserDTO user = new UserDTO();
        user.setPassword(userDTO.getNewPassword());
        return updateUser(id, user);
    }

    // 转换方法：将 User 转换为 UserVO
    private UserVO convertToUserVO(User user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    // 获取源对象中值为 null 的字段名
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
