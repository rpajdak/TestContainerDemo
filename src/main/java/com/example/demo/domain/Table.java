package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@javax.persistence.Table(name = "table_dupa")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
class Table {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  @Column(updatable = false)
  Long id;


  @NonNull
  @ToString.Include
  @Column(name = "uploader_name", nullable = false)
  String uploaderName;

}
