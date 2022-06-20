package com.cdtu.epidemicvisualization.controller;

import com.cdtu.epidemicvisualization.entity.Patient;
import com.cdtu.epidemicvisualization.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Patient)表控制层
 *
 * @author makejava
 * @since 2022-06-20 20:22:57
 */
@RestController
@RequestMapping("patient")
public class PatientController {
    /**
     * 服务对象
     */
    @Resource
    private PatientService patientService;

    /**
     * 分页查询
     *
     * @param patient     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Patient>> queryByPage(Patient patient, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientService.queryByPage(patient, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Patient> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.patientService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patient 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Patient> add(Patient patient) {
        return ResponseEntity.ok(this.patientService.insert(patient));
    }

    /**
     * 编辑数据
     *
     * @param patient 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Patient> edit(Patient patient) {
        return ResponseEntity.ok(this.patientService.update(patient));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.patientService.deleteById(id));
    }

}

