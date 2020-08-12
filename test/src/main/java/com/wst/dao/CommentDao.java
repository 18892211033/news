package com.wst.dao;

import com.wst.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    /**
     * 添加一条评论
     */
    int addComment(Comment comment);
    /**
     * 根据新闻id查询所有相关评论
     */
    List<Comment> getAllComment(@Param("newsid") Integer newsid);
    /**
     * 根据用户id查询所有评论
     */
    List<Comment> getAllUComment(@Param("userid") Integer userid);
    /**
     * 删除一条评论
     */
    int delComment(@Param("id") Integer id);
    /**
     * 根据评论id删除多条评论
     */
    int delComments(List<Integer> ids);
}
