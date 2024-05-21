package br.com.tamboril.repositories;

import br.com.tamboril.domain.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
