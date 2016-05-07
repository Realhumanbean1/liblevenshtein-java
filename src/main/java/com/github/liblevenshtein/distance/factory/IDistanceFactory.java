package com.github.liblevenshtein.distance.factory;

import java.io.Serializable;

import com.github.liblevenshtein.transducer.Algorithm;
import com.github.liblevenshtein.distance.IDistance;

/**
 * Builds instances of Levenshtein distance metrics.
 * @param <Term> Type of the terms whose distances are measurable.
 * @author Dylon Edwards
 * @since 2.1.0
 */
public interface IDistanceFactory<Term> extends Serializable {

  /**
   * Returns a Levenshtein distance metric that utilizes the request algorithm.
   * @param algorithm Type of metric that should be returned
   * @return A distance metric that utilizes the request alagorithm
   */
  IDistance<Term> build(Algorithm algorithm);
}