/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.usermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public final class BaseRoles {
    /**
     * poweruser
     */
    public static final Role POWER_USER = Role.valueOf("POWER_USER");
    /**
     * Utente
     */
    public static final Role CLIENT_USER = Role.valueOf("CLIENT_USER");
    /**
     * Base Administrator
     */
    public static final Role ADMIN = Role.valueOf("ADMIN");
    /**
     *
     */
    public static final Role SALES_CLERK = Role.valueOf("SALES_CLERK");
    /**
     *
     */
    public static final Role WAREHOUSE_EMPLOYEE = Role.valueOf("WAREHOUSE EMPLOYEE");

    public static final Role AGV_MANAGER = Role.valueOf("AGV MANAGER");

    public static final Role SALES_MANAGER = Role.valueOf("SALES_MANAGER");
    /**
     *
     */
    public static final Role CUSTOMER = Role.valueOf("CUSTOMER");

    /**
     * get available role types for adding new users
     *
     * @return
     */
    public static Role[] nonUserValues() {
        return new Role[]{ADMIN, SALES_CLERK, WAREHOUSE_EMPLOYEE, AGV_MANAGER, SALES_MANAGER, CUSTOMER};
    }

    public boolean isCollaborator(final Role role) {
        return role != CLIENT_USER;
    }
}
