package com.auto.controller;

import com.auto.entity.User;
import com.auto.mapper.UserMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auto.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = { "/getTuserList" }, method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> r = userService.getAll();
		return r;
	}

	@ApiOperation(value = "创建用户", notes = "根据user对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体Tuser", required = true, dataType = "Tuser")
	@RequestMapping(value = "/postUser", method = RequestMethod.POST)
	public String postUser(@RequestBody User user) {
		userService.insert(user);
		return "success";
	}

//	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
//	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public Tuser getTuser(@PathVariable Long id) {
//		return tusers.get(id);
//	}
//
//	@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的Tuser信息来更新用户详细信息")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
//			@ApiImplicitParam(name = "Tuser", value = "用户详细实体Tuser", required = true, dataType = "Tuser") })
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public String putTuser(@PathVariable Long id, @RequestBody Tuser Tuser) {
//		Tuser u = tusers.get(id);
//		u.setNickname(Tuser.getNickname());
//		tusers.put(id, u);
//		return "success";
//	}
//
//	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
//	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public String deleteTuser(@PathVariable Long id) {
//		tusers.remove(id);
//		return "success";
//	}
}