package com.learn.cms.site.controller;

import com.learn.cms.site.model.Msg;
import com.learn.cms.site.service.MsgService;
import com.learn.cms.site.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * This controller demonstrates RESTful service, note this RESTful service is
 * secured by SecurityInterceptor, you cannot call it directly, you need to do
 * BASIC authentication from your request.<br>
 * <br>
 *
 * @author cyper
 */
@Controller
public class MsgController {
    private final Logger logger = LoggerFactory.getLogger(MsgController.class);

    @Autowired
    private MsgService msgService;

    /**
     * RESTful method, list all msgs.
     *
     * @return
     */
    @RequestMapping(value = "/admin/msg", produces = {"application/json"}, method = GET)
    public
    @ResponseBody
    Result list() {
        try {
            List<Msg> msgs = msgService.findAll();
            return Result.ok(msgs);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    /**
     * View-based method, list all msgs.
     *
     * @return
     */
    @RequestMapping(value = "/admin/msg", method = GET)
    public String list(Model model) {
        // Call RESTful method to avoid repeating lookup logic
        model.addAttribute("msgs", list().getData());

        // FIXME deal with possible system exception here

        // Return the view to use for rendering the response
        return "admin/msg/msg_index";
    }

    /**
     * create or update a msg.
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/admin/msg", method = POST)
    public
    @ResponseBody
    Result save(@RequestBody Map<String, String> param) {

        logger.debug(param.toString());

        String id = param.get("id");

        try {
            Msg msg = new Msg();
            if (id != null) {
                msg.setId(Long.valueOf(id));
                msg = msgService.findById(msg.getId());
            }

            msg.setName(param.get("name"));
            msg.setContent(param.get("content"));
            msg.setPhone(param.get("phone"));
            msg.setQq(param.get("qq"));
            msg.setStatus(Integer.valueOf(param.get("status")));

            if (id != null) {
                msgService.updateMsg(msg);

            } else {
                msgService.saveMsg(msg);
            }

            return Result.OK;

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    /**
     * view a single msg.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/msg/{id}", method = GET)
    public
    @ResponseBody
    Result view(@PathVariable Long id) {
        try {
            Msg msg = msgService.findById(id);
            return Result.ok(msg);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }

    }

    /**
     * delete a msg.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/msg/delete/{id}", method = GET)
    public
    @ResponseBody
    Result delete(@PathVariable Long id) {
        try {
            msgService.deleteById(id);
            return Result.OK;

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

}
