package com.microservices.accounts.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author Ridho Suhaebi Arrowi
 */

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

	/**
	 * Returns the current auditor of the application.
	 *
	 * @return the current auditor.
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("ACCOUNTS_MS");
	}
}
