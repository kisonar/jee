/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.client.web.servlet;

import com.mossad.jpa.lib.domain.abstraction.AbstractEntity;
import com.mossad.jpa.lib.domain.user.User;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author mmigdal
 */
class UserTableBuilder {

    public UserTableBuilder() {
    }

    void printTableWithUsers(PrintWriter out, List<User> users) {

        if (users != null && users.size() > 0) {
            out.println("<table border=\"1\" cellpadding=\"5\" >");
            out.println("<caption>Users table</caption>");
            out.println(
                "<th>Name</th>"
                    + "<th>Surname</th>"
                    + "<th>email</th>"
                    + "<th>password</th>"
                    + "<th>id</th>"
            );

            for (User user : users) {
                out.println("<tr>");
                geneateCellEntry(out, user.getName());
                geneateCellEntry(out, user.getSurname());
                geneateCellEntry(out, user.getEmail());
                geneateCellEntry(out, user.getPassword());
                geneateCellEntry(out, user.getId());
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }

    void printTableWithEntries(PrintWriter out, String title, List<AbstractEntity> entities) {

        if (entities != null && entities.size() > 0) {
            out.println("<table border=\"1\" cellpadding=\"5\" >");
            out.println("<caption>" + title + "</caption>");
            out.println("<th>id</th>" + "<th>value</th>");
            for (AbstractEntity entry : entities) {
                out.println("<tr>");
                geneateCellEntry(out, entry.getId());
                geneateCellEntry(out, entry.getValue());
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }

    private void geneateCellEntry(PrintWriter out, Object value) {
        out.println("<td>");
        out.println(value);
        out.println("</td>");
    }
}