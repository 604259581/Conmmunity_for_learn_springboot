package com.community.demo.cache;

import com.community.demo.dto.TagsDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagsDTO> get() {
        List<TagsDTO> tagDTOS = new ArrayList<>();
        TagsDTO program = new TagsDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("javascript", "php", "css", "html", "html5", "java", "node.js", "python", "c++", "c", "golang", "objective-c", "typescript", "shell", "swift", "c#", "sass", "ruby", "bash", "less", "asp.net", "lua", "scala", "coffeescript", "actionscript", "rust", "erlang", "perl"));
        tagDTOS.add(program);

        TagsDTO framework = new TagsDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel", "spring", "express", "django", "flask", "yii", "ruby-on-rails", "tornado", "koa", "struts"));
        tagDTOS.add(framework);


        TagsDTO server = new TagsDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux", "nginx", "docker", "apache", "ubuntu", "centos", "缓存 tomcat", "负载均衡", "unix", "hadoop", "windows-server"));
        tagDTOS.add(server);

        TagsDTO db = new TagsDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql", "redis", "mongodb", "sql", "oracle", "nosql memcached", "sqlserver", "postgresql", "sqlite"));
        tagDTOS.add(db);

        TagsDTO tool = new TagsDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("git", "github", "visual-studio-code", "vim", "sublime-text", "xcode intellij-idea", "eclipse", "maven", "ide", "svn", "visual-studio", "atom emacs", "textmate", "hg"));
        tagDTOS.add(tool);
        return tagDTOS;

    }
    public static String filterInvalid(String tags){
        String[] split = tags.split(",");
        List<TagsDTO> tagsDTOS = get();
        List<String> tagList = tagsDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        // flatMap是遍历二层循环，先拿到tagsDTOS的所有getTags()的List然后拼接成toList
        String invaid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        //用filter进行筛选不包含在tagList中的无效标签，然后将这些标签用","拼接生成String
        return  invaid;
    }
}
