package com.example.demo.fileud;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	@PostMapping("singleFileUpload")
	@ResponseBody
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "false";
		}
		String fileName = file.getOriginalFilename();
		int size = (int) file.getSize();
		System.out.println(fileName + "-->" + size);

		String path = "H:/temp";
		File dest = new File(path + "/" + fileName);
		if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest); // 保存文件
			return "true";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "false";
		} catch (IOException e) {
			e.printStackTrace();
			return "false";
		}
	}

	@PostMapping("twoFileUpload")
	@ResponseBody
	public String twoFileUpload(HttpServletRequest request) throws IOException {
		File savePath = new File("H:/temp");

		if (!savePath.exists()) {
			savePath.mkdirs();
		}
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					File saveFile = new File(savePath, file.getOriginalFilename());
					stream = new BufferedOutputStream(new FileOutputStream(saveFile));

					stream.write(bytes);

					stream.close();
				} catch (Exception e) {
					if (stream != null) {
						stream.close();
						stream = null;
					}
					return "第 " + i + " 个文件上传有错误" + e.getMessage();
				}
			} else {
				return "第 " + i + " 个文件为空";
			}
		}
		return "所有文件上传成功";
	}

	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	public void download(@PathVariable String id,HttpServletResponse res) {
		System.out.println("download id=================="+id);
		String fileName = "H:/temp/Linux学习笔记.doc";
		
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		//res.setHeader("Content-Disposition", "attachment;filename=Linux学习笔记.doc");
		try {
			res.setHeader("Content-Disposition", "attachment; fileName="+  fileName +";filename*=utf-8''"+URLEncoder.encode("Linux学习笔记.doc","UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	}

}
